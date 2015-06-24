package jp.levelfive.kaigishitsu;

import java.util.List;

public class YoyakuOptionList {
	private List<YoyakuOption> rooms;
	private List<YoyakuOption> users;
	private List<YoyakuOption> usages;
	private List<Integer> hours;
	private List<Integer> minits;
	private YoyakuDAO yoyakuDao;
	private static final YoyakuOptionList instance = new YoyakuOptionList();
	private YoyakuOptionList(){

	}

	public static YoyakuOptionList getInstance(){
		return instance;
	}

	public List<YoyakuOption> getRooms() {
		return rooms;
	}
	public void setRooms(List<YoyakuOption> rooms) {
		this.rooms = rooms;
	}
	public List<YoyakuOption> getUsers() {
		return users;
	}
	public void setUsers(List<YoyakuOption> users) {
		this.users = users;
	}
	public List<YoyakuOption> getUsages() {
		return usages;
	}
	public void setUsages(List<YoyakuOption> usages) {
		this.usages = usages;
	}

	public List<Integer> getHours(){
		return hours;
	}

	public List<Integer> getMinits(){
		return minits;
	}
}

class YoyakuOption {

	private int id;
	private String name;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}