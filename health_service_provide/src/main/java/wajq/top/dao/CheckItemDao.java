package wajq.top.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import wajq.top.pojo.CheckItem;

/**
 * @author LeLe.Zhang
 * @program: copy_health
 * @description: dao类
 * @create: 2022-10-07 15:25
 */
public interface CheckItemDao {
    /**
     * 新增
     * @param checkItem
     */
    public void add(CheckItem checkItem);

    /**
     * 分页查询
     * @param value
     * @return Page
     */
    public Page<CheckItem> find(@Param("value") String value);

    /**
     * 查询组中注册情况
     * @param id
     * @return
     */
    public int findCountByCheckItemId(Integer id);

    /**
     * 通过id删除
     * @param id
     */
    public void delete(Integer id);

    /**
     * 更新操作
     * @param checkItem
     */
    public void update(CheckItem checkItem);

    /**
     * 查询通过id
     */
    public CheckItem findById(Integer id);
}
