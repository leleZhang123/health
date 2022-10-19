package wajq.top.service;

import wajq.top.entity.PageResult;
import wajq.top.entity.QueryPageBean;
import wajq.top.pojo.CheckItem;


public interface CheckItemServcie {
    /**
     * 新增
     */
    public void add(CheckItem checkItem);

    /**
     * 分页
     */
    public PageResult findPage(QueryPageBean queryPageBean);

    /**
     * 删除
     */
    public void delete(Integer id);

    /**
     * 修改
     * @param checkItem
     */
    public void edit(CheckItem checkItem);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public CheckItem findById(Integer id);
}


