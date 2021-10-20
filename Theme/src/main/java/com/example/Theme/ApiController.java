package com.example.Theme;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ApiController {
    private List<List<String>> themes = new ArrayList<List<String>>();
    private List<String> comments = new ArrayList<>();
    @GetMapping("themes")
    public List<List<String>> getTheme() {
        return themes;
    }

    /* curl -X POST http://localhost:8080/themes -H 'Content-Type: text/plain' -d 'text' */
    @PostMapping("themes")
    public void addTheme(@RequestBody String text) {
        themes.add(Collections.singletonList(text));
    }

    /* В строке браузера: http://localhost:8080/themes/index */
    @GetMapping("themes/{index}")
    public List<String> getTheme(@PathVariable("index") Integer index) {
        return themes.get(index);
    }


    /* В строке браузера: http://localhost:8080/themes/count */
    @GetMapping("themes/count")
    public int countTheme() {
        return themes.size();
    }

    /* curl -X DELETE http://localhost:8080/themes/index */
    @DeleteMapping("themes/{index}")
    public void deleteTheme(@PathVariable("index") Integer index) {
        themes.remove((int) index);
    }
    /* curl -X DELETE http://localhost:8080/themes */
    @DeleteMapping("themes")
    public void deleteThemes() {
        int a = themes.size();
        int b=a-1;
        while (b!=-1){
            themes.remove(b);
            b=b-1;
        }
    }

    /* curl -X PUT http://localhost:8080/themes/index -H 'Content-Type:
   text/plain' -d 'text' */
    @PutMapping("themes/{index}")
    public void updateTheme(
            @PathVariable("index") Integer i,
            @RequestBody String text) {
        themes.remove((int) i);
        themes.add(i, Collections.singletonList(text));
    }



}