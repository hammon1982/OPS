package ops.mvc.service.demo;

import java.util.List;

import ops.mvc.pageModel.base.PageFilter;
import ops.mvc.pageModel.demo.Demo;

public interface DemoServiceI {

	public List<Demo> dataGrid(Demo demo, PageFilter ph);

	public Long count(Demo demo, PageFilter ph);

	public void add(Demo demo);

	public void delete(Long id);

	public void edit(Demo demo);

	public Demo get(Long id);

}
