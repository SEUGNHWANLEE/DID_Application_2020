<template>
    <Page>
    <ActionBar title="인증 화면" />
    <StackLayout>
      <TabView :selectedIndex="selectedIndex" iosIconRenderingMode="alwaysOriginal">

        <TabViewItem title="Personal ID" iconSource="~/images/icon.png">
            <Button text="개인정보 입력" />
        </TabViewItem>

        <TabViewItem title="여권정보" iconSource="~/images/icon.png">
           <Button text="개인정보 입력" />
        </TabViewItem>

          <TabViewItem title="학생증" iconSource="~/images/icon.png">
            <Button text="개인정보 입력" />
        </TabViewItem>

</TabView>
    </StackLayout>
    </Page>
</template>

<script>
    export default {
        methods: {
            onButtonTap() {
                this.$navigateBack();
            },
            
        
            getPassword(){
                this.$navigateBack();
            }
        }
    };
</script>

<style>
</style>