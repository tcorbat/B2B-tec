package ch.b2btec.ui;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Category;
import ch.b2btec.bl.domain.Product;

public class CatalogTreeModel implements TreeModel {

	private Catalog catalog;
	private final static String ROOT = "Catalog";
	
	public CatalogTreeModel(Catalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public Object getRoot() {
		return ROOT;
	}

	@Override
	public Object getChild(Object parent, int index) {
		return children(parent).get(index);
	}

	@Override
	public int getChildCount(Object parent) {
		Object expectedCategoryParent = (parent == ROOT) ? null : parent;
		var numberOfChildren = catalog.getCategories().stream()
				.filter(category -> category.getParentCategory() == expectedCategoryParent)
				.count();
		if (parent instanceof Category) {
			Category category = (Category) parent;
			numberOfChildren += category.getProducts().size();
		}
		assert(numberOfChildren < Integer.MAX_VALUE);
		return (int)numberOfChildren;
	}

	@Override
	public boolean isLeaf(Object node) {
		return node instanceof Product;
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if (parent instanceof Category) {
			Category category = (Category) parent;
			category.getProducts().indexOf(child);
		} else if (parent == ROOT) {
			var rootCategories = getRootCategories();
			return rootCategories.indexOf(child);
		}
		return -1;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
	}

	private List<Category> getRootCategories() {
		return catalog.getCategories().stream().filter(category -> Objects.nonNull(category.getParentCategory())).collect(Collectors.toList());
	}
	
	private List<Object> children(Object parent) {
		if (parent == ROOT) {
			return getRootCategories().stream().collect(Collectors.toList());
		} else if (parent instanceof Category) {
			Category parentCategory = (Category) parent;
			return Stream.concat(catalog.getCategories().stream()
					.filter(c -> c.getParentCategory() == parentCategory), parentCategory.getProducts().stream())
					.collect(Collectors.toList());
		}
		return null;
	}
}
