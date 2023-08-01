package board.data;

import javax.servlet.ServletContext;

import DB.DBconnect;

public class BoardDAOImpl extends DBconnect implements BoardDAO {
	
	public BoardDAOImpl(ServletContext application) {
		super(application);
	}
}
