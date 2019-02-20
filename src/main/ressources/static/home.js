$(()=>{
    $("#postArticleButton").click((e)=>{
      $.post("/api/article", "gros test").done((data)=>{
        console.debug('data : ' + data);
        //
        $("#articlesBlock").load('/greeting');
      });
    });
})
