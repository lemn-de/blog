
<template>
  <el-card>
    <h1 class="me-author-name">木之本</h1>
    <div class="me-author-description">
      <span><i class="me-author-description"> &nbsp;你所热爱的，就是你的生活！</i></span>
    </div>
    <div class="me-author-tool">
      <i @click="showTool(qq)" :title="qq.title" class="iconfont">&#xe882;</i>
      <i @click="showTool(github)" :title="github.title" class="iconfont">&#xe885;</i>
      <i @click="showTool(bilibili)" :title="bilibili.title" class="iconfont">&#xe646;</i>
    </div>
  </el-card>

</template>
</style>
<script>
  export default {
    name: 'CardMe',
    data() {
      return {
        qq: {title: 'QQ', message: '1830249116'},
        github: {
          title: 'Github',
          message: '<a target="_blank" href="https://github.com/lemn-de">https://github.com/lemn-de</a>'
        },
        bilibili: {
          title: '哔哩哔哩',
          message: '<a target="_blank" href="https://space.bilibili.com/61786491">https://space.bilibili.com/61786491</a>'
        }
      }
    },
    methods: {
      showTool(tool) {
        this.$message({
          duration: 0,
          showClose: true,
          dangerouslyUseHTMLString: true,
          message: '<strong>' + tool.message + '</strong>'
        });
      }
    }
  }
</script>



<style scoped>
  .me-author-name {
    text-align: center;
    font-size: 30px;
    border-bottom: 1px solid #5FB878;
  }

  .me-author-description {
    padding: 8px 0;
  }

  .me-icon-job {
    padding-left: 16px;
  }

  .me-author-tool {
    text-align: center;
    padding-top: 10px;
  }

  .me-author-tool i {
    cursor: pointer;
    padding: 4px 10px;
    font-size: 30px;
  }
</style>
