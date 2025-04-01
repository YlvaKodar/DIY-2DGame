package Main;

import Entity.Entity;

public class CollisionChecker {
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.worldX + entity.bodySolidity.x;
        int entityRightWorldX = entityLeftWorldX + entity.bodySolidity.width;
        int entityTopWorldY = entity.worldY + entity.bodySolidity.y;
        int entityBottomWorldY = entityTopWorldY + entity.bodySolidity.height;

        int entityLeftCol = entityLeftWorldX/gamePanel.tileSize;
        int entityRightCol = entityRightWorldX/gamePanel.tileSize;
        int entityTopRow = entityTopWorldY/gamePanel.tileSize;
        int entityBottomRow = entityBottomWorldY/gamePanel.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if(gamePanel.tileManager.tiles[tileNum1].collision || gamePanel.tileManager.tiles[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tileManager.tiles[tileNum1].collision || gamePanel.tileManager.tiles[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if(gamePanel.tileManager.tiles[tileNum1].collision || gamePanel.tileManager.tiles[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tileManager.tiles[tileNum1].collision || gamePanel.tileManager.tiles[tileNum2].collision){
                    entity.collisionOn = true;
                }
        }

    }

    public int checkObject(Entity entity, boolean player){
        int index = 999;

        for(int i = 0; i < gamePanel.obj.length; i++){
            if (gamePanel.obj[i] != null){
                //Get entity's bodysolidity:
                entity.bodySolidity.x = entity.worldX + entity.bodySolidity.x;
                entity.bodySolidity.y = entity.worldY + entity.bodySolidity.y;

                //Get object's bodySolidity
                gamePanel.obj[i].bodySolidity.x = gamePanel.obj[i].worldX + gamePanel.obj[i].bodySolidity.x;
                gamePanel.obj[i].bodySolidity.y = gamePanel.obj[i].worldY + gamePanel.obj[i].bodySolidity.y;

                switch (entity.direction){
                    case "up":
                        entity.bodySolidity.y -= entity.speed;
                        if (entity.bodySolidity.intersects(gamePanel.obj[i].bodySolidity)){ //Intersect här och inte för tiles för att inte behöva kolla alla tiles, utan bara två.
                            if(gamePanel.obj[i].collision){
                                entity.collisionOn = true;
                            }
                            if (player){
                                index = i;
                            }
                        }break;
                    case "down":
                        entity.bodySolidity.y += entity.speed;
                        if (entity.bodySolidity.intersects(gamePanel.obj[i].bodySolidity)){
                            if(gamePanel.obj[i].collision){
                                entity.collisionOn = true;
                            }
                            if (player){
                                index = i;
                            }
                        }break;
                    case "left":
                        entity.bodySolidity.x -= entity.speed;
                        if (entity.bodySolidity.intersects(gamePanel.obj[i].bodySolidity)){
                            if(gamePanel.obj[i].collision){
                                entity.collisionOn = true;
                            }
                            if (player){
                                index = i;
                            }
                        }break;
                    case "right":
                        entity.bodySolidity.x += entity.speed;
                        if (entity.bodySolidity.intersects(gamePanel.obj[i].bodySolidity)){
                            if(gamePanel.obj[i].collision){
                                entity.collisionOn = true;
                            }
                            if (player){
                                index = i;
                            }
                        }break;
                }
                entity.bodySolidity.x = entity.bodySolidityDefaultX;
                entity.bodySolidity.y = entity.bodySolidityDefaultY;
                gamePanel.obj[i].bodySolidity.x = gamePanel.obj[i].bodySolidityDefaultX;
                gamePanel.obj[i].bodySolidity.y = gamePanel.obj[i].bodySolidityDefaultY;
            }
        }
        return index;
    }

    public int checkEntity(Entity entity, Entity[] target){
        int index = 999;

        for(int i = 0; i < target.length; i++){
            if (target[i] != null){
                //Get entity's bodysolidity:
                entity.bodySolidity.x = entity.worldX + entity.bodySolidity.x;
                entity.bodySolidity.y = entity.worldY + entity.bodySolidity.y;

                //Get object's bodySolidity
                target[i].bodySolidity.x = target[i].worldX + target[i].bodySolidity.x;
                target[i].bodySolidity.y = target[i].worldY + target[i].bodySolidity.y;

                switch (entity.direction){
                    case "up":
                        entity.bodySolidity.y -= entity.speed;
                        if (entity.bodySolidity.intersects(target[i].bodySolidity)){ //Intersect här och inte för tiles för att inte behöva kolla alla tiles, utan bara två.
                                entity.collisionOn = true;
                                index = i;
                        }break;
                    case "down":
                        entity.bodySolidity.y += entity.speed;
                        if (entity.bodySolidity.intersects(target[i].bodySolidity)){
                                entity.collisionOn = true;
                                index = i;
                        }break;
                    case "left":
                        entity.bodySolidity.x -= entity.speed;
                        if (entity.bodySolidity.intersects(target[i].bodySolidity)){
                                entity.collisionOn = true;
                                index = i;
                        }break;
                    case "right":
                        entity.bodySolidity.x += entity.speed;
                        if (entity.bodySolidity.intersects(target[i].bodySolidity)){
                        entity.collisionOn = true;
                        index = i;
                        }break;
                }
                entity.bodySolidity.x = entity.bodySolidityDefaultX;
                entity.bodySolidity.y = entity.bodySolidityDefaultY;
                target[i].bodySolidity.x = target[i].bodySolidityDefaultX;
                target[i].bodySolidity.y = target[i].bodySolidityDefaultY;
            }
        }
        return index;
    }

    public void checkPlayer(Entity entity){
        //Get entity's bodysolidity:
        entity.bodySolidity.x = entity.worldX + entity.bodySolidity.x;
        entity.bodySolidity.y = entity.worldY + entity.bodySolidity.y;

        //Get object's bodySolidity
        gamePanel.player.bodySolidity.x = gamePanel.player.worldX + gamePanel.player.bodySolidity.x;
        gamePanel.player.bodySolidity.y = gamePanel.player.worldY + gamePanel.player.bodySolidity.y;

        switch (entity.direction) {
            case "up":
                entity.bodySolidity.y -= entity.speed;
                if (entity.bodySolidity.intersects(gamePanel.player.bodySolidity)) { //Intersect här och inte för tiles för att inte behöva kolla alla tiles, utan bara två.
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entity.bodySolidity.y += entity.speed;
                if (entity.bodySolidity.intersects(gamePanel.player.bodySolidity)) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entity.bodySolidity.x -= entity.speed;
                if (entity.bodySolidity.intersects(gamePanel.player.bodySolidity)) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entity.bodySolidity.x += entity.speed;
                if (entity.bodySolidity.intersects(gamePanel.player.bodySolidity)) {
                    entity.collisionOn = true;
                }
                break;
        }
        entity.bodySolidity.x = entity.bodySolidityDefaultX;
        entity.bodySolidity.y = entity.bodySolidityDefaultY;
        gamePanel.player.bodySolidity.x = gamePanel.player.bodySolidityDefaultX;
        gamePanel.player.bodySolidity.y = gamePanel.player.bodySolidityDefaultY;
    }
}
