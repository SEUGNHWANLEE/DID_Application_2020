<template>
  <Page>
    <ActionBar title="Service" height="30" backgroundColor="#6EC8FF">
      <ActionItem
        @tap="$goto('main',navOptions)"
        text="<"
        ios.position="left"
        android.systemIcon="ic_menu_back"
      />
    </ActionBar>
     
    <StackLayout>
      <TabView :selectedIndex="selectedIndex" iosIconRenderingMode="alwaysOriginal">
        <TabViewItem title="Personal ID">
          <Button text="ID : 개인정보 하라고" @tap="goToEmail" />
        </TabViewItem>
        <TabViewItem title="여권정보">
          <Button text="여권 : 개인정보 입력" />
        </TabViewItem>

        <TabViewItem title="학생증" >
          <Button text="학생증 : 개인정보 입력" />
        </TabViewItem>
      </TabView>

    </StackLayout>
  </Page>
</template>

<script>
export default {
  methods:{
    goToEmail(){
      confirm('메일인증을 진행합니다.')
      .then(result => {
      if (result == true){
        $goto('identifyEmail',navOptions);
      }
      else console.log(result);
})

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

<style>
</style>