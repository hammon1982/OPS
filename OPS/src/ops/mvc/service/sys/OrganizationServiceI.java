package ops.mvc.service.sys;

import java.util.List;

import ops.mvc.pageModel.base.Tree;
import ops.mvc.pageModel.sys.Organization;

public interface OrganizationServiceI {

	public List<Organization> treeGrid();

	public void add(Organization organization);

	public void delete(Long id);

	public void edit(Organization organization);

	public Organization get(Long id);

	public List<Tree> tree();

}
