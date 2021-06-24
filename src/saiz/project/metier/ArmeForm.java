package saiz.project.metier;

import java.sql.SQLException;

import saiz.project.dao.CommandeDao;
import saiz.project.pojo.Arme;

public class ArmeForm {
	
	CommandeDao commandeDao = new CommandeDao();
	
	int Aid;
	
	public void getIDA(Arme arme) throws ClassNotFoundException, SQLException {
	//	Aid = commandeDao.selectIdArme(arme);
		
	}

}
