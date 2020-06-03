package com.lkc.service;

import com.lkc.mapper.HelloMapper;
import com.lkc.model.Tree;
import com.lkc.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloServiceImpl implements HelloService{

    @Autowired
    private HelloMapper helloMapper;


    @RequestMapping("/hi2")
    @Override
    public String hello2() {
        return "调用成功2";
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


}
