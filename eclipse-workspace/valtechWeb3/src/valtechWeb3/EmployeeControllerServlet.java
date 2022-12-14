package valtechWeb3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.valtech.dao.Employee;
import com.valtech.dao.EmployeeDAO;

@WebServlet(urlPatterns= {"/empCtlr"})
public class EmployeeControllerServlet extends HttpServlet {
	private EmployeeDAO dao;
	@Override
	public void init() throws ServletException {
		dao = new EmployeeDAO();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String submit = req.getParameter("submit");
		try {
			if("New Employee".equals(submit)) {
				req.getRequestDispatcher("createEmp.jsp").forward(req, resp);;
				return;
			}
			if("Save".equals(submit)) {
				Employee e= new Employee();
				e.setId(dao.getNextValidId());
				e.setName(req.getParameter("name"));
				e.setAge(Integer.parseInt(req.getParameter("age")));
				e.setGender(Integer.parseInt(req.getParameter("gender")));
				e.setSalary(Float.parseFloat(req.getParameter("salary")));
				dao.saveEmployee(e);
			}
			if("updateEmp".equals(submit)) {
				//EmployeeDAO dao=new EmployeeDAO();
				Employee e= new Employee();
				int id = Integer.parseInt(req.getParameter("Id"));
				e.setId(id);
				e.setName(req.getParameter("name"));
				e.setAge(Integer.parseInt(req.getParameter("age")));
				e.setGender(Integer.parseInt(req.getParameter("gender")));
				e.setSalary(Float.parseFloat(req.getParameter("salary")));
				dao.updateEmployee(e);
				
			}
			loadEmpsAndGotoEmpsPage(req, resp);;
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// write logic here and fwd to jsp page
		 try {
	            
		        String empId = req.getParameter("empId");
		        String submit= req.getParameter("submit");
		        if (empId == null) {
		            loadEmpsAndGotoEmpsPage(req, resp);
		            return;
		        }
				int id = Integer.parseInt(req.getParameter("empId"));
				if("delete".equals(submit)) {
					dao.getEmployee(id);
					loadEmpsAndGotoEmpsPage(req, resp);
		        	dao.deleteEmployee(id);
		        	return;
		        }
				if("update".equals(submit)) {
					Employee e = dao.getEmployee(id);
					req.setAttribute("e", e);
					req.getRequestDispatcher("updateEmp.jsp").forward(req,resp);
					return;
				}
		
					Employee e=dao.getEmployee(id);
					req.setAttribute("e", e);//logic to load the data
					req.getRequestDispatcher("emp.jsp").forward(req, resp);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	private void loadEmpsAndGotoEmpsPage(HttpServletRequest req, HttpServletResponse resp)
			throws Exception, ServletException, IOException {
		List<Employee> emps = dao.getEmployees();
		req.setAttribute("emps", emps);
		req.getRequestDispatcher("emps.jsp").forward(req, resp);
	}
	
}
