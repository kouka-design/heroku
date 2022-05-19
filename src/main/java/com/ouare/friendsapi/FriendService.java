package com.ouare.friendsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    public List<Friend>  getFriends(){
        return friendRepository.findAll();
    }
    public Friend addFriend(Friend friend){
        return friendRepository.save(friend);
    }
    public Friend updateFriend(Friend friend){
        return friendRepository.save(friend);
    }
     public void deleteFriend(Integer id){
        friendRepository.deleteById(id);
     }

}
