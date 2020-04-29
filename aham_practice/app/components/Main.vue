<template>
  <Page>
    <FlexboxLayout flexDirection="column">
      <Label text="AHAM LOGO will be here" />

      <FlexboxLayout ref="main_content" backgroundColor="White" height="400" width="*">
        <DockLayout stretchLastChild="true" width="*">
          <Button text=">" dock="right" width="20" @tap="getNextPage" />
          <Button text="<" dock="left" width="20" @tap="getPrevPage" />

          <StackLayout width="300">
            <template v-if="count === 0">
              <FlexboxLayout flexDirection="column">
                <Label name="num" :text="items[0].no" />
                <Label name="desc" :text="items[0].desc" />
              </FlexboxLayout>
            </template>
            <template v-else-if="count === 1">
              <FlexboxLayout flexDirection="column">
                <label name="num" :text="items[1].no" />
                <Label name="desc" :text="items[1].desc" />
              </FlexboxLayout>
            </template>
            <template v-if="count === 2">
              <FlexboxLayout flexDirection="column">
                <label name="num" :text="items[2].no" />
                <Label name="desc" :text="items[2].desc" />
              </FlexboxLayout>
            </template>
            <template v-else>
              <Label name="desc" text />
            </template>
          </StackLayout>
        </DockLayout>
      </FlexboxLayout>

      <FlexboxLayout flexDirection="column">
        <Button text="시작하기ㅋ" @tap="$goto('password',navOptions)"></Button>
        <FlexboxLayout>
          <Button text="약관 및 동의" @tap="getInfo"></Button>
          <Button text="복구하기" @tap="getRestore"></Button>
        </FlexboxLayout>
      </FlexboxLayout>
    </FlexboxLayout>
  </Page>
</template>

<script>
export default {
  data() {
    return {
      count: 0,
      items: [
        {
          no: 1,
          desc: "this is the first page"
        },
        {
          no: 2,
          desc: "this is the second page"
        },
        {
          no: 3,
          desc: "this is the third page"
        }
      ]
    };
  },
  methods: {
    getPrevPage() {
      console.log("get to prev page" + this.count);
      if (this.count > 0) {
        this.count--;
      }
    },
    getNextPage() {
      console.log("get to next page" + this.count);
      if (this.count < 2) {
        this.count++;
      }
    },
    getStartApp() {
      console.log("get start app");
    },
    getInfo() {
      console.log("get information");
    },
    getRestore() {
      console.log("will restore information");
    }
  },
  computed: {
    navOptions() {
      return {
        clearHistory: true,
        backstackVisible: true,
        transition: {
          name: "fade",
          duration: 380,
          curve: "easeIn"
        }
      };
    }
  }
};
</script>

<style scoped>
FlexboxLayout {
  justify-content: center;
  align-items: center;
}
TextView {
  margin-bottom: 20;
}
</style>