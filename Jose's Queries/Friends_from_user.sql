--Getting friends from user_id = 3--
SELECT user_name
  FROM user,
       (
           SELECT friends_userID2 AS myFriendID
             FROM user,
                  Friends
            WHERE friends_userID = user_id AND 
                  friends_userID = 3
       )
       AS getFriends
 WHERE getFriends.myFriendID = user_id;
