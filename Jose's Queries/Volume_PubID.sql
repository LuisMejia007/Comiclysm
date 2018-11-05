SELECT comic_name
  FROM comic,
       volume
 WHERE comic_volumeName = volume_name AND 
       volume_publisherID = 1;