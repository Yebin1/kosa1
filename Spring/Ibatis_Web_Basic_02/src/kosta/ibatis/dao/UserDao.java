package kosta.ibatis.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kosta.ibatis.dto.UserDto;
import kosta.ibatis.utils.IbatisUtil;

public class UserDao {

	public void insert(UserDto dto) throws SQLException{
		SqlMapClient client = IbatisUtil.getSqlMapClient();
		//IbatisUtil.getSqlMapClient().insert(arg0)
		
		client.insert("insertuser", dto); //"insertuser" Map 파일 id 값
	}
	public void update(UserDto dto) throws SQLException{
		SqlMapClient client = IbatisUtil.getSqlMapClient();
		client.update("updateuser", dto);
	}
	public void delete(String userid) throws SQLException{
		SqlMapClient client = IbatisUtil.getSqlMapClient();
		client.delete("deleteuser",userid);
	}
	
	
	//전체 조회(UserDto  여러건)
	public List<UserDto> list() throws SQLException{  // 만약 한건이라면 타입만 UserDto으로 바꿔줘서 받고 리턴하면 된다
		SqlMapClient client = IbatisUtil.getSqlMapClient();
//		List<UserDto> list = client.queryForList("selectAllUsers");
//		return list;
		return client.queryForList("selectAllUsers");  //데이터가 한건이 아닌데요? -> Dto하나는 한건의 데이터만 가질수 있는데, Ibatis가 List를 알아서 만들음
		//DTO 객체 row 개수만큼 생성 (List 담는 것)
		//List<UserDto>
		
		
	}
	
	public UserDto findById(String userid) throws SQLException{
		SqlMapClient client = IbatisUtil.getSqlMapClient();
		return (UserDto)client.queryForObject("selectAllByUserid", userid);
	}
	
}




