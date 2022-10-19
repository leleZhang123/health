package wajq.top.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import wajq.top.dao.CheckItemDao;
import wajq.top.entity.PageResult;
import wajq.top.entity.QueryPageBean;
import wajq.top.pojo.CheckItem;
import java.util.List;

/**
 * @author LeLe.Zhang
 * @program: copy_health
 * @description: 项目检查的实现类
 * @create: 2022-10-07 15:21
 */
@Service(interfaceClass = CheckItemServcie.class)
@Transactional
public class ServiceImpl implements CheckItemServcie {
    
    @Autowired
    private CheckItemDao checkItemDao;

    /**
     * 新增
     * @param checkItem
     */
    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    /**
     * 分页
     * @param queryPageBean
     * @return PageResult
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //赋值
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        Page<CheckItem> page = checkItemDao.find(queryString);
        //使用pageHelper在底层是拦截器直接把语句后面直接加入limit(1,10)
        //select * from 表 limit(1,10)
        PageHelper.startPage(currentPage,pageSize);
        //获取总数以及得到结果list
        long total = page.getTotal();
        List<CheckItem> result = page.getResult();
        //返回一个结果
        return new PageResult(total,result);
    }

    /**
     * 由id查询删除一条
     * @param id
     */
    @Override
    public void delete(Integer id) {
        //先查询是否在组中已经注册了
        int ids = checkItemDao.findCountByCheckItemId(id);
        if(ids>0){
            RuntimeException rm = new RuntimeException();
            throw rm;
        }
        //删除
        checkItemDao.delete(id);
    }

    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.update(checkItem);
    }

    @Override
    public CheckItem findById(Integer id) {
        CheckItem byId = checkItemDao.findById(id);
        return byId;
    }


}
