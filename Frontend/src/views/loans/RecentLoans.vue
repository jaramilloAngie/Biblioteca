<script setup>

import { ref, onMounted } from 'vue';

const loans = ref([]);

onMounted(() => {
    getRecentLoans();
});

const getRecentLoans = async () => {
    loans.value = []
    loans.value.push(
        { label: 'El gran Gatsby', label2: 'B.Scott Fitzgeraid Fecha de mayo, 2024' },
        { label: 'El gran Gatsby', label2: 'B.Scott Fitzgeraid Fecha de mayo, 2024' },
        { label: 'El gran Gatsby', label2: 'B.Scott Fitzgeraid Fecha de mayo, 2024' },
        { label: 'El gran Gatsby', label2: 'B.Scott Fitzgeraid Fecha de mayo, 2024' }
    );
};
</script>
<template>
    <div>
        <ul class="gap-2 p-1 m-0 w-full bg-amber-50 ">
            <li v-for="item in loans" :key="item.to" class="mb-2 w-full flex flex-col">
                <label class="font-bold text-2xl ml-3">{{ item.label }}</label>
                <label class="text-gray-700 ml-3">{{ item.label2 }}</label>
                <hr class="my-4 border-1 border-#D36F3F" />
            </li>
        </ul>
    </div>
</template>