package at.nacs.twitter.logic;

import at.nacs.twitter.persistence.domain.Tweet;
import at.nacs.twitter.persistence.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TweeterMangar {

    private final TweetRepository tweetRepository;

    public Tweet storeNewTweet(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        tweetRepository.save(tweet);
        return tweet;
    }

    public List<Tweet> displayAll() {
        return tweetRepository.findAllByOrderByTimestampDesc();
    }

    public List<Tweet> displayAllByUser(String user) {
        return tweetRepository.findAllByUserOrderByTimestampDesc(user);
    }

    public Tweet like(String id) {
        Tweet tweet = tweetRepository.findById(id).orElse(null);
        int likes = tweet.getLikes();
        tweet.setLikes(likes + 1);
        tweetRepository.save(tweet);
        return tweet;
    }

    public void comment(String id,String message) {
        Tweet tweet = tweetRepository.findById(id).orElse(null);
        List<String> listComment = tweet.getComments();
        listComment.add(message);
        tweet.setComments(listComment);
        tweetRepository.save(tweet);

    }


}
