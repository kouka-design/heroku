package com.ouare.friendsapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/friends")
@CrossOrigin
@Api("/friends")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/list")
    @ApiOperation(value="Rechercher une liste d'amis", notes = "Cette méthode permet de chercher une liste d'amis",response = Friend.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "Resultats retournés avec succès"),
            @ApiResponse(code=404,message = "Aucun ami n'existe dans la BDD")
    })
    public List<Friend> getFriends(){
        return friendService.getFriends();
    }

    @PostMapping("/save")
    @ApiOperation(value="Enregistrer un ami", notes = "Cette méthode permet d'enregistrer ou de modifier un ami",response = Friend.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "L'objet friend créé / modifié"),
            @ApiResponse(code=400,message = "L'objet friend n'est pas valide"),
    })
    public Friend addFriend(@RequestBody Friend friend){
        return friendService.addFriend(friend);
    }

    @PutMapping("/update/{id}/edit")
    public Friend updateFriend(@PathVariable("id") Integer id,@RequestBody Friend friend){
        return friendService.updateFriend(friend);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFriend(@PathVariable("id") Integer id){
        friendService.deleteFriend(id);
    }
}
