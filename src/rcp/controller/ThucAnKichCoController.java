package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.ThucAnKichCo;
import rcp.model.ThucAnKichCoModel;

public class ThucAnKichCoController {
	public static ArrayList<ThucAnKichCo> traCuu(int maLoaiThucAn) throws SQLException
	{
		return ThucAnKichCoModel.traCuu(maLoaiThucAn);
	}

}
