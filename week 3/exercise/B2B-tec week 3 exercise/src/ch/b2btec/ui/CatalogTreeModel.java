package ch.b2btec.ui;

import java.util.Collections;
import java.util.List;
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
		return children(parent).size();
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
		return children(parent).indexOf(child);
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
	}

	private List<Object> children(Object parent) {
		if (parent == ROOT) {
			return catalog.getCategories().stream().collect(Collectors.toList());
		} else if (parent instanceof Category) {
			Category parentCategory = (Category) parent;
			return Stream.concat(parentCategory.getSubCategories().stream(), parentCategory.getProducts().stream())
					.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}
}
