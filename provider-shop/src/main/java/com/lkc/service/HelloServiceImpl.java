package com.lkc.service;

import com.lkc.mapper.HelloMapper;
import com.lkc.model.FangAn;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.lkc.model.Tree;
import com.lkc.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class HelloServiceImpl implements HelloService{

    @Resource
    private HelloMapper helloMapper;


    @RequestMapping("/hi2")
    @Override
    public String hello2() {
        return "调用成功2";
    }

    @GetMapping("/selectList")
    @Override
    public Map<String, Object> selectList(@RequestParam Integer page,@RequestParam Integer rows) {
        Integer total = helloMapper.getcount();
        List<FangAn> list = helloMapper.selectfangan((page-1)*rows,rows);

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }




    @GetMapping("/select")
    @Override
    public List<UserEntity> select() {
        return helloMapper.select();
    }



    @RequestMapping("/selectTree")
    @Override
    public List<Tree> selectTree() {
        return selectNodes(-1);
    }

    private List<Tree> selectNodes(Integer id) {
        List<Tree> treeList=helloMapper.selectNodesById(id);
        for (Tree tree : treeList) {
            List<Tree> TreeList = selectNodes(tree.getId());
            if(TreeList!=null && !TreeList.isEmpty()){
                tree.setNodes(TreeList);
                tree.setSelectable(true);
            }else{
                tree.setSelectable(true);
            }
        }
        return treeList;
    }

    @RequestMapping("/toFangAnGuAn")
    @Override
    public List<FangAn> selectFangAnGuAn() {
        return helloMapper.selectFangAnGuAn();
    }

    @RequestMapping("/selectXQ")
    @Override
    public FangAn selectXiang(@RequestBody Integer id) {
        FangAn fangAns = helloMapper.selectFangAnGuAn1(id);
        helloMapper.selectXiang(id);

        return fangAns;
    }

}
