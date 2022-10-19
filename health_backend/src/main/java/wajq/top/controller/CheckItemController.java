package wajq.top.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wajq.top.constant.MessageConstant;
import wajq.top.entity.PageResult;
import wajq.top.entity.QueryPageBean;
import wajq.top.entity.Result;
import wajq.top.pojo.CheckItem;
import wajq.top.service.CheckItemServcie;


/**
 * @author LeLe.Zhang
 * @program: copy_health
 * @description: 项目检查的控制类
 * @create: 2022-10-07 15:02
 */
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    @Reference
    private CheckItemServcie checkItemServcie;

    //新增
    @RequestMapping("/add")
    public Result addCheckItem(@RequestBody CheckItem checkItem){
        try{
            checkItemServcie.add(checkItem);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    /**
     * 分页查询
     * @param queryPageBean:
     * @return PageResult
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        //执行查询的语句
        PageResult page = checkItemServcie.findPage(queryPageBean);
        return page;
    }

    /**
     * 删除
     * @param id
     * @return Result
     */
    @RequestMapping("/delete")
    public Result deleteCheckItem(Integer id){
        try{
            checkItemServcie.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_CHECKGROUP_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/edit")
    public Result editCheckItem(@RequestBody CheckItem checkItem){
        try{
            checkItemServcie.edit(checkItem);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_ADDRESS_FAIL);
        }
        return new Result(true, MessageConstant.EDIT_ADDRESS_SUCCESS);
    }

    @RequestMapping("/findById")
    public CheckItem findCheckItemById(Integer id) {
        CheckItem page = null;
        //执行查询的语句
        page= checkItemServcie.findById(id);
       return page;
    }

}
