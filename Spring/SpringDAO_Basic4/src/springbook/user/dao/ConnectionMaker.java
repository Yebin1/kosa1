package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	// ν¨μ (μΆμ)
	Connection makeConnection() throws ClassNotFoundException, SQLException;
}
