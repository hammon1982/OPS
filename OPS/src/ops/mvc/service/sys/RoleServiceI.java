package ops.mvc.service.sys;

import java.util.List;

import ops.mvc.pageModel.base.PageFilter;
import ops.mvc.pageModel.base.Tree;
import ops.mvc.pageModel.sys.Role;

public interface RoleServiceI {

	public List<Role> dataGrid(Role role, PageFilter ph);

	public Long count(Role role, PageFilter ph);

	public void add(Role role);

	public void delete(Long id);

	public void edit(Role role);

	public Role get(Long id);

	public void grant(Role role);

	public List<Tree> tree();

}
