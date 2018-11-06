SELECT comic_name, user_name
FROM Inventory
INNER JOIN User ON inventory_userID = user_id
INNER JOIN Comic ON inventory_id = comic_inventoryID;