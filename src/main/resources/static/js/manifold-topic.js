/**父话题点击事件 */
function clickFatherTopic() {
    newAncestor(fatherTopic.fatherTopic);

    setTimeout("arrageSons();", 500);
}

function newAncestor(father_id) {
    $.ajax({
        url: 'manifold/topic/ancestor',
        method: 'get',
        data: {
            'topicId': father_id
        },
        dataType: 'json',
        success: function(responseData) {
            fatherTopic = responseData;
            var content = responseData.topicDesc.toString().substring(0, 25) + "...";
            var div = `
            <div id="father" onclick="clickFatherTopic()" class="father-topic">
                <div class="topic-avatar">
                    <img src="` + responseData.avatar + `" height="50" width="50" />
                </div>
                <div class="topic-title">
                     ` + responseData.name + `
                </div>
                <div class="topic-content">
                    ` + content + `
                </div>
                <div class="topic-follow">
                    <button onclick="alert("hi")"><i class="fa fa-plus fa-1g"></i>关注</button>
                </div>
            </div>
            `;
            $('.topic-container').html(div);
            loadSonTopic(fatherTopic.topicId);
        }
    })
}

/**子话题点击事件 */
function clickSonTopic(father_id, son_id) {
    /**变化 动画 */
    removeSon(son_id);
    $("#" + father_id).animate({}, 1500, function() {
        $(this).css({
            "transform": "translate(0px,-1000px)"
        });
    });
    $("#" + son_id).attr("class", "father-topic");
    $("#" + son_id).animate({}, 1500, function() {
        $(this).css({
            "transform": "translate(100px,0px)"
        });
    });

    var selectTopicId = $("#" + son_id + " input").val();

    var sonTopicId = son_id.split('son');
    loadSonTopicQuestion(sonTopic[sonTopicId[1]].topicId);

    /**加载新父话题数据*/
    for (var i = 0; i < countSon; i++) {
        if (sonTopic[i].topicId == selectTopicId) {
            fatherTopic = sonTopic[i];
            newFather(fatherTopic);
        }
    }
    /**获得子类数据 */
    loadSonTopic(fatherTopic.topicId);
    /**排列子类 */
    setTimeout("arrageSons();", 500);


}

function newFather(father) {
    var content = father.topicDesc.toString().substring(0, 25) + "...";
    var div = `
            <div id="father" onclick="clickFatherTopic()" class="father-topic">
                <div class="topic-avatar">
                    <img src="` + father.avatar + `" height="50" width="50" />
                </div>
                <div class="topic-title">
                     ` + father.name + `
                </div>
                <div class="topic-content">
                    ` + content + `
                </div>
                <div class="topic-follow">
                    <button><i class="fa fa-plus fa-1g"></i>关注</button>
                </div>
            </div>
            `;
    $('.topic-container').html(div);
}



/**排列子话题 */
function arrageSons() {
    var x = 0;
    var y = 150
    for (var i = 0; i < countSon; i++) {
        var son = $('#son' + i);
        son.attr("class", "son-topic");
        trans("son" + i, x, y);
        (function(i) {
            son.on("click", function() {
                clickSonTopic("father", "son" + i);
            })
        })(i);

        x += 370;
        if (x >= 740) {
            x = 0;
            y += 100;
        }
    }
}

function trans(son, x, y) {
    $('#' + son).animate({}, 1500, function() {
        $(this).css({
            "transform": "translate(" + x + "px," + y + "px)"
        });
    })
}

function removeSon(son_id) {
    for (var i = 0; i < countSon; i++) {
        var son = $('#son' + i);
        if (son_id != ('son' + i)) {
            son.animate({}, 1500, function() {
                $(this).css({
                    "transform": "translate(0px,-1000px)"
                });
            });
        }
    }

}


/**加载子话题 */
function loadSonTopic(topicId) {
    $.ajax({
        url: 'manifold/topic/son',
        method: 'get',
        data: {
            'topicId': topicId
        },
        dataType: 'json',
        success: function(responseData) {
            sonTopic = responseData;
            countSon = 0;
            var div = ``;
            $.each(responseData, function(i, v) {
                countSon++;
                var content = v.topicDesc.toString().substring(0, 20) + "...";
                div += `
                <div id="son` + i + `" class="son-topic-out">
                    <div class="topic-avatar">
                        <img src="` + v.avatar + `" height="50" width="50" />
                    </div>
                    <div class="topic-title">
                        ` + v.name + `
                    </div>
                    <div class="topic-content">
                        ` + content + `
                    </div>
                    <div class="topic-follow">
                        <button><i class="fa fa-plus fa-1g"></i>关注</button>
                    </div>
                    <input type="hidden" value="` + v.topicId + `"/>
                </div>
                `;
            });
            $('.topic-container').append(div);
        }
    })
}

/**加载根话题 */
function loadRoot() {
    $.ajax({
        url: 'manifold/topic/root',
        method: 'get',
        dataType: 'json',
        success: function(responseData) {
            fatherTopic = responseData;
            var content = responseData.topicDesc.toString().substring(0, 25) + "...";
            var div = `
            <div id="father" class="father-topic">
                <div class="topic-avatar">
                    <img src="` + responseData.avatar + `" height="50" width="50" />
                </div>
                <div class="topic-title">
                     ` + responseData.name + `
                </div>
                <div class="topic-content">
                    ` + content + `
                </div>
                <div class="topic-follow">
                        <button><i class="fa fa-plus fa-1g"></i>关注</button>
                </div>
            </div>
            `;
            $('.topic-container').html(div);
        }
    })
}

function loadSonTopicQuestion(topicId) {
    $.ajax({
        url: 'manifold/question/topic',
        method: 'get',
        data: {
            'topicId': topicId
        },
        success: function(returnData) {
            var div = '';
            $.each(returnData, function(i, v) {
                var title = v.title;
                if (v.title.length > 20)
                    title = title.substring(0, 20);
                div += `
                <div class="q-item">
                    <div class="item-header">
                        <img class="user-avatar" src="image/user_avatar/` + v.user.avatar + `">
                        <div class="user-info">
                            <div class="user-name">
                                ` + v.user.username + `
                            </div>
                            <div class="user-industry">
                                ` + v.user.industry + `
                            </div>
                        </div>
                    </div>
                    <div onclick="goToQuestion(` + v.questionId + `)" class="item-body">
                        ` + title + `
                    </div>
                </div>
                `;
            })
            $('.main-container-body').html(div);
        },
        dataType: 'json'
    })
}