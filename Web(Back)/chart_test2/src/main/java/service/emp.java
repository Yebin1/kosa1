package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.empdao;
import net.sf.json.JSONArray;

public class emp implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			empdao dao = new empdao();
			JSONArray jsonarray = dao.getemp();
			System.out.println(jsonarray);
			out.print(jsonarray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
