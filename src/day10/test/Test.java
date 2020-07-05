package day10.test;

import java.util.Map;

import day10.bean.Dept;
import day10.dbutils.DeptDao;

public class Test {
	public static void main(String[] args) {
		for (Map<String, Object> map : new DeptDao().findByJob("clerk")) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String mapKey = entry.getKey();
				Object mapValue = entry.getValue();
				System.out.print(mapKey + ":" + mapValue+" ");
			}
			System.out.println();
		}
	}
}
