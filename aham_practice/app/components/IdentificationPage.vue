<template>
  <Page>
    <ActionBar title="Service">
      <ActionItem text="Go Back"
        @tap="$goto('main',navOptions)"
        ios.position="left"
        android.systemIcon="ic_menu_back"
      />
    </ActionBar>
     
    <StackLayout>
      <TabView :selectedIndex="selectedIndex" iosIconRenderingMode="alwaysOriginal">
        <TabViewItem title="Personal ID">
          <Button text="ID : 개인정보 하라고yo" @tap="goToEmail()" />
        </TabViewItem>
        <TabViewItem title="여권정보">
          <Button text="여권 : 개인정보 입력" @tap="goToEmail()" />
        </TabViewItem>

        <TabViewItem title="학생증" >
          <Button text="학생증 : 개인정보 입력" @tap="goToEmail()" />
        </TabViewItem>
      </TabView>

    </StackLayout>
  </Page>
</template>
<script>


import Identifyemail from "./IdentifyEmail";

export default {
  methods:{
    goToEmail(){
      confirm('메일인증을 진행합니다 !')
      .then(result => {
      if (result == true){
        console.log(result);
        this.$navigateTo(Identifyemail);
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