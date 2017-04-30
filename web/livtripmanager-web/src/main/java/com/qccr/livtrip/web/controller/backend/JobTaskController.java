package com.qccr.livtrip.web.controller.backend;

import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.enums.task.JobTaskLogStateEnum;
import com.qccr.livtrip.biz.service.task.JobTaskLogService;
import com.qccr.livtrip.biz.service.task.JobTaskService;
import com.qccr.livtrip.model.dto.task.JobTaskLogDTO;
import com.qccr.livtrip.model.task.JobTask;
import com.qccr.livtrip.model.task.JobTaskLog;
import com.qccr.livtrip.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/21 19:26 Exp $$
 */
@Controller
@RequestMapping("/backend/task")
public class JobTaskController extends BaseController{

    @Autowired
    private JobTaskService jobTaskService;
    @Autowired
    private JobTaskLogService jobTaskLogService;

    @RequestMapping("/list")
    public String list(String taskCode,String state, Integer pageNumber, Integer pageSize, ModelMap modelMap){
        PageInfo<JobTask> jobTaskPageInfo =jobTaskService.pageQueryJobTask(taskCode,state,pageNumber,pageSize);
        modelMap.put("page", jobTaskPageInfo);
        modelMap.put("taskCode", taskCode);
        modelMap.put("state", state);
        return "/backend/task/list";
    }
    @RequestMapping("logs")
    public String logs(Integer taskId, String state,Integer pageNumber, Integer pageSize, ModelMap modelMap){
        System.out.println("taskId" + taskId+ "state:" + state);
        PageInfo<JobTaskLogDTO> jobTaskLogPageInfo = jobTaskLogService.pageQueryJobTaskLogDTO(taskId,state,pageNumber, pageSize);


        //jobTaskLogPageInfo.getList().stream().map(jobTaskLogDTO -> JobTaskLogStateEnum.getNameByCode(jobTaskLogDTO.getState())).collect(Collectors.toList());;
        modelMap.put("page", jobTaskLogPageInfo);
        return "/backend/task/logs";
    }
}
