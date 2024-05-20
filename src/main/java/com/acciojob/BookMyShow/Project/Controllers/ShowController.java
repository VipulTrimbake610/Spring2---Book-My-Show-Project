package com.acciojob.BookMyShow.Project.Controllers;

import com.acciojob.BookMyShow.Project.Requests.AddShowRequest;
import com.acciojob.BookMyShow.Project.Services.ShowService;
import com.acciojob.BookMyShow.Project.models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("add")
    public ResponseEntity addShow(@RequestBody AddShowRequest addShowRequest){
        String result = showService.addShow(addShowRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("getShow")
    public Show getShow(@RequestParam Integer id){

        return showService.getShow(id);
    }
}
