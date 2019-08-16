// 很久以前实现的2048游戏，原本打算学了设计模式简化一下，发现没法优化了……

log.info("log init");
/******************************************************************
**                                                               **
**                                                               **
**                      author: sid.tadpole                      **
**                      time:    2017.3.8                        **
**                      path:    BeiJing                         **
**                                                               **
**                                                               **
******************************************************************/


/********************** GLOBAL_INIT_BEGIN ************************/

var STATE = true;                                        //记录状态
var IS_RUN = true;                                       //运行状态
var GAME_OVER = false;                                   //游戏状态
var ERROR = -1;                                          //运行异常

var score = 0;                                           //总分

var gameMap = [];                                        //游戏地图


/************************ IS_OVER_BEGIN ***************************
**
**
**    判断游戏是否结束： 若任意两个相邻的元素相等，则返回false
**
**
*/

var isGameOver = function() {
    for (var row = 0; row < 4; row++) {
        for (var col = 0; col < 4; col++) {
            if (gameMap[row][col] == 0) {
                return false;
            }
            if (row < 3) {
                if (gameMap[row+1][col] == gameMap[row][col]) {
                    return false;
                }
            }
            if (col < 3) {
                if (gameMap[row][col+1] == gameMap[row][col]) {
                    return false;
                }
            }
        }
        }
    return true;
}

/********************* UPDATE_VIEW_BEGIN *************************
**
**
**                         更新游戏地图
**
**
*/

function updateView() {
    for(var row = 0; row < 4; row++) {
        for(var col = 0; col < 4; col++) {
            var gameElem = document.getElementById("c"+row+col);
            gameElem.innerHTML = gameMap[row][col] == 0 ? ("") : (gameMap[row][col]);
            gameElem.className = gameMap[row][col] == 0 ? ("cell") : ("cell n" + gameMap[row][col]);
        }
    }

    var span = document.getElementById("score");
    span.innerHTML = score;

    if(isGameOver()) {
        var gameElem = document.getElementById("gameOver");
        var finalScore = document.getElementById("score");

        STATE = GAME_OVER;
        finalScore.innerHTML = score;
        gameElem.style.display = "block";
    }
}

/*************************** IS_FULL *****************************
**
**
**                      判断游戏地图是否已满
**
**
*/

var isFull = function() {
    for (var row = 0; row < 4; row++) {
        for (var col = 0; col < 4; col++) {

            if (gameMap[row][col] == 0) {
                return false;
            }
        }
    }
    return true;
}

/*********************** RANDOM_NUM_BEGIN **********************
**
**
**             随机位置生成2或4，若地图满，则返回
**
**
*/

function randomNum() {
    if (isFull()) { return; }
    while (1) {
        var row = Math.floor(Math.random() * 4);
        var col = Math.floor(Math.random() * 4);

        if (0 == gameMap[row][col]) {
            gameMap[row][col] = Math.random()<0.5 ? 2 : 4;
            break;
        }
    }
}

/**************************** MOVE ****************************
**                                                           **
**                                                           **
**    gameUpMove gameRightMove gameDownMove gameLeftMove     **
**                                                           **
**                                                           **
***************************************************************/

/************************ UP_MOVE_BEGIN ***********************
**
**
**  判断是否可以移动，若可以，则执行移动操作，
**
**
*/

function gameUpMove()　{
    var isUpMove = function() {
        for (var row = 1; row < 4; row++) {
            for (var col = 0; col < 4; col++) {
                if (0 != gameMap[row][col]) {
                if(gameMap[row-1][col]==0 || gameMap[row-1][col] == gameMap[row][col]) {
                    return true;
                    }
                }
            }
        }
        return false;
    }

    function upMove() {
        if (isUpMove()) {
            for(var col = 0; col < 4; col++){
                moveUpInCol(col);
            }
            randomNum();
            updateView();
        }
    }

    function moveUpInCol(col) {
        for(var row = 0; row <= 2; row++) {
            var nextRow = getNextDown(row,col);
            if (nextRow == ERROR) { break; }
            else {
                if (gameMap[row][col] == 0) {
                gameMap[row][col] = gameMap[nextRow][col];
                gameMap[nextRow][col] = 0;
                row--;
                }
                else if (gameMap[row][col] == gameMap[nextRow][col]) {
                gameMap[row][col] *= 2;
                score += gameMap[row][col];
                gameMap[nextRow][col] = 0;
                }
            }
        }
    }

    var getNextDown = function(row,col) {
        for (var i = row+1; i < 4; i++) {

            if (gameMap[i][col] != 0) {
                return i;
            }
        }
        return ERROR;
    }

    upMove();
}


/************************ RIGHT_MOVE_BEGIN **********************
**
**
**
**
*/
function gameRightMove() {
    var isRightMove = function() {
        for (var row = 0; row < 4; row++) {
            for (var col = 0; col < 3; col++) {
                if (0 != gameMap[row][col]) {
                    if(gameMap[row][col+1]==0 || gameMap[row][col+1] == gameMap[row][col]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    function rightMove() {
        if (isRightMove()) {
            for(var row = 0; row < 4; row++){
                moveRightInRow(row);
            }
            randomNum();
            updateView();
        }
    }

    function moveRightInRow(row) {
        for(var col = 3; col >= 1; col--) {
            var nextCol = getNextLeft(row,col);

            if (nextCol == ERROR) { break; }
            else {
                if (gameMap[row][col] == 0) {
                    gameMap[row][col]=gameMap[row][nextCol];
                    gameMap[row][nextCol]=0;
                    col++;
                }
                else if (gameMap[row][col] == gameMap[row][nextCol]) {
                    gameMap[row][col] *= 2;
                    score += gameMap[row][col];
                    gameMap[row][nextCol] = 0;
                }
            }
        }
    } 

    var getNextLeft = function(row,col) {
        for (var i = col-1; i >= 0; i--) {
            if (gameMap[row][i] != 0) {
                return i;
            }
        }
        return ERROR;
    }

    rightMove();
}


/************************* DOWN_MOVE_BEGIN ************************
**
**
**
**
*/

function gameDownMove() {
    var isDownMove = function() {
        for (var row = 0; row < 3; row++) {
            for (var col = 0; col < 4; col++) {
                if (0 != gameMap[row][col]) {
                    if(gameMap[row+1][col]==0 || gameMap[row+1][col] == gameMap[row][col]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    function downMove() {
        if (isDownMove()) {
            for(var col = 0; col < 4; col++){
                moveDownInCol(col);
            }
            randomNum();
            updateView();
        }
    }

    function moveDownInCol(col) {
        for(var row = 3; row >= 1; row--) {
            var nextRow = getNextUp(row,col);

            if (nextRow == ERROR) { break; }
            else {
                if (gameMap[row][col] == 0) {
                    gameMap[row][col] = gameMap[nextRow][col];
                    gameMap[nextRow][col] = 0;
                    row++;
                }
                else if (gameMap[row][col] == gameMap[nextRow][col]) {
                    gameMap[row][col] *= 2;
                    score += gameMap[row][col];
                    gameMap[nextRow][col] = 0;
                }
            }
        }
    }

    var getNextUp = function(row,col) {
        for (var i = row-1; i >= 0; i--) {
            if (gameMap[i][col] != 0) {
                return i;
            }
        }
        return ERROR;
    }

    downMove();
}

/************************* LEFT_MOVE_BEGIN **********************
**
**
**
**
*/

function gameLeftMove() {
    var isLeftMove = function() {
        for (var row = 0; row < 4; row++) {
            for (var col = 1; col < 4; col++) {
                if (0 != gameMap[row][col]) {
                    if(gameMap[row][col-1]==0 || gameMap[row][col-1] == gameMap[row][col]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    function leftMove() {
        if (isLeftMove()) {
            for(var row = 0; row < 4; row++){
                moveLeftInRow(row);
            }
            randomNum();
            updateView();
        }
    }

    function moveLeftInRow(row) {
        for(var col = 0; col <= 2; col++) {
            var nextCol = getNextRight(row,col);

            if (nextCol == ERROR) { break; }
            else {
                if (gameMap[row][col] == 0) {
                    gameMap[row][col]=gameMap[row][nextCol];
                    gameMap[row][nextCol]=0;
                    col--;
                }
                else if (gameMap[row][col] == gameMap[row][nextCol]){
                    gameMap[row][col] *= 2;
                    score += gameMap[row][col];
                    gameMap[row][nextCol] = 0;
                }
            }
        }
    }

    var getNextRight = function(row,col) {
        for (var i = col+1; i < 4; i++) {
            if (gameMap[row][i] != 0) {
                return i;
            }
        }
        return ERROR;
    }

    leftMove();
}


/************************* ADD_TOUCH_EVENT **********************
**
**
**          添加触摸事件
**
*/

function addTouch() {
    var startX, startY, moveEndX, moveEndY, X, Y;

    document.addEventListener("touchstart", function(e) {
　　　　startX = e.changedTouches[0].pageX,
　　　　startY = e.changedTouches[0].pageY;
　　});
　　document.addEventListener("touchmove", function(e) {
　　　　moveEndX = e.changedTouches[0].pageX,
　　　　moveEndY = e.changedTouches[0].pageY,
　　　　X = moveEndX - startX,
　　　　Y = moveEndY - startY;　　
　　});
    document.addEventListener("touchend", function() {
        if (Math.abs(X) > Math.abs(Y) && X > 0 ) {
            gameRightMove();
        } else if ( Math.abs(X) > Math.abs(Y) && X < 0 ) {
            gameLeftMove();
        } else if ( Math.abs(Y) > Math.abs(X) && Y > 0) {
            gameDownMove();
        } else if ( Math.abs(Y) > Math.abs(X) && Y < 0 ) {
            gameUpMove();
        }
    });
}

/************************ START_GAME_BEGIN **********************
**
**
**
**
*/

function startGame() {
    gameMap =  [[0,0,0,0],
                [0,0,0,0],
                [0,0,0,0],
                [0,0,0,0]];
    score = 0;
    STATE == IS_RUN;
    var gameElem = document.getElementById("gameOver");
    gameElem.style.display = "none";
    randomNum();
    randomNum();
    updateView();
}


/***************************** WINDOW ***************************
**
**
**
**
*/

(function() {
    startGame();
    document.onkeydown = function() {
        switch (event.keyCode) {
            case 38: gameUpMove();
                break;
            case 39: gameRightMove();
                break;
            case 40: gameDownMove();
                break;
            case 37: gameLeftMove();
                break;
        }
    }

    addTouch();
})();