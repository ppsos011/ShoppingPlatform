<template>
    <div id="BotMiddle">
        <div id="PicSlider"><PicSlider/></div>
        <div id="booknews">
            <BookNews/>
        </div>
    </div>
</template>
<script>
import PicSlider from './PicSlider.vue';
import BookNews from './BookNews.vue';
export default {
    components: {
        PicSlider,
        BookNews
    },
}
</script>
<style scoped>
#PicSlider{
    width: 990px;
    height: 320px;
}
#booknews{
    width: 990px;
    height: 250px;
}
</style>
