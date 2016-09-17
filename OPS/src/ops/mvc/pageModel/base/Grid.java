package ops.mvc.pageModel.base;

import java.util.List;

public class Grid<T> implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long total = 0L;
	private List<T> rows;
	private List<T> footer;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public List<T> getFooter() {
		return footer;
	}

	public void setFooter(List<T> footer) {
		this.footer = footer;
	}
}
