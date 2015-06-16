package jp.levelfive.framework;

import java.util.List;

public interface MyEntityDao {
	List<MyEntity> getList() throws DataAccessException;
}
