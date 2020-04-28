<template>
    <Page>
    <ActionBar title="핀 비밀번호 확인" />
    <StackLayout>
        <Label text="비밀번호를 다시 입력해주세요 !" />

         <TextField secure="true" hint="password" />
         <Span text="핀 번호 입력" fontWeight="Bold" />
        <Button text="뒤로가기"  @tap="onButtonTap" />
         <Button text="6자리 입력"  @tap="getPassword" />

    </StackLayout>
    </Page>
</template>

<script>
    export default {
        methods: {
            onButtonTap() {
                this.$navigateBack();
            }
            
        },
            getPassword(){
                this.$navigateBack();
            },
        data() {
            return {};
        }
    };
</script>

<style>
</style>