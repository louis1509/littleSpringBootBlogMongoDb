/** DOM READY EXECUTION **/

$(()=>{


    $("#postArticleButton").click((e)=>{
        const articleInput = HomeJS.retrieveArticleData();
        console.debug(JSON.stringify(articleInput));
        $.ajax({
            url: "/api/article",
            type: "POST",
            dataType: "json", // expected format for response
            contentType: "application/json", // send as JSON
            data: JSON.stringify(articleInput),
            complete : function(){

                $("#articlesBlock").load('/greeting');
            },
            success : function(){
                alert('success');

            },
            error : function(error){
                alert('error : ' + error);
            }
        });


    });
})
/** USEFUL VARIABLES TO HOME.JS **/
let base64photo;
/** USEFUL FUNCTIONS TO HOME.JS **/
let HomeJS = {

    retrieveArticleData: function () {
        let articleTitle = $("#titleArticle").val();
        let articleDescription = $("#descriptionArticle").val();
        let articleContent = $("#contenu").val();
        let articleIllustration = document.getElementById('imgInp').files[0];
        if(articleIllustration) articleIllustration = HomeJS.getBase64(articleIllustration).then(data => base64photo =data, error => console.debug(error));

        //create article object
        const articleInput =  HomeJS.createArticle(articleTitle, articleDescription, articleContent, base64photo );
        return articleInput;


        console.debug(articleIllustration);
    },
    getBase64: function getBase64(file) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result);
            reader.onerror = error => reject(error);
        });
    },

    createArticle : function(articleTitle, articleDescription, articleContent, articleIllustration){
        const articleInput =
            {
                base64photo: articleIllustration,
                article: {
                    title: articleTitle,
                    description: articleDescription,
                    text: articleContent
                }
            };
        return articleInput;
    }
}


