/**
 * 用于打开创建问题窗口
 */
function openQuestionEdit() {
    var url = 'question-edit.html';

    //弹出窗口
    layer.open({
        type: 2,
        title: '问题编辑',
        content: url,
        area: ['500px', '675px'],
        maxmin: true

    });
}

/**
 * 用于打开收藏窗口
 */
function openCollectionEdit(answerId) {
    var url = 'collection.html';

    //弹出窗口
    layer.open({
        type: 2,
        title: '我的收藏',
        content: url,
        area: ['500px', '675px'],
        maxmin: true
    });
}

/**
 * 打开个人资料
 */
function openUserInfoEdit() {
    var url = 'user-info-edit.html';
    //弹出窗口
    layer.open({
        type: 2,
        title: '个人资料',
        content: url,
        area: ['500px', '700px'],
        maxmin: true
    });
}