package at.nacs.twitter.communication;

import at.nacs.twitter.logic.TweeterMangar;
import at.nacs.twitter.persistence.domain.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweeterEndPoint {
    private final TweeterMangar tweeterMangar;

    @GetMapping
    List<Tweet> get() {
        return tweeterMangar.displayAll();
    }

    @GetMapping("/user/{user}")
    List<Tweet> getAllByUser(@PathVariable String user) {
        return tweeterMangar.displayAllByUser(user);
    }

    @PostMapping
    Tweet post(@RequestBody Tweet tweet) {
        tweeterMangar.storeNewTweet(tweet);
        return tweet;
    }

    @PutMapping("/{id}/likes")
    Tweet updateLikes(@PathVariable String id) {
        return tweeterMangar.like(id);
    }
    @PutMapping("/{id}/comments")
    void updateComment(@PathVariable String id ,@RequestBody String message) {
        tweeterMangar.comment(id,message);
    }
//    @PutMapping("/{id}/comments")
//    Tweet updateComment(@PathVariable String id, @RequestBody String newComment) {
//        return tweeterMangar.comment(id, newComment);
//    }
//    @PutMapping("/{id}/comments/{MM}")
//    Tweet updateComment(@PathVariable String id, @PathVariable String MM) {
//        return tweeterMangar.comment(id, MM);
//    }
}
