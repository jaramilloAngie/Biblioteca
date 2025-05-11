<script setup>

import { ref, onMounted } from 'vue';

const books = ref([]);

onMounted(() => {
    //const loggedInUserInfo = { role: 'admin', name: 'Admin User' };
    //userRole.value = loggedInUserInfo.role;
    getBooks();
});

const getBooks = () => {
    books.value = []
    books.value.push(
        { book: "https://images.cdn3.buscalibre.com/fit-in/360x360/61/8d/618d227e8967274cd9589a549adff52d.jpg" },
        { book: "https://marketplace.canva.com/EAF55Kx4v24/1/0/1003w/canva-portada-libro-fantas%C3%ADa-ilustrativo-verde-_pp1hAU8znQ.jpg" },
        { book: "https://i.pinimg.com/736x/22/fd/25/22fd25dddb9acdf6a828ee27f184f250.jpg" },
        { book: "https://www.tregolam.com/wp-content/uploads/2016/03/Portada_Jacinto-Aran_Small.jpg" },
        { book: "https://images.cdn3.buscalibre.com/fit-in/360x360/61/8d/618d227e8967274cd9589a549adff52d.jpg" },
        { book: "https://marketplace.canva.com/EAF55Kx4v24/1/0/1003w/canva-portada-libro-fantas%C3%ADa-ilustrativo-verde-_pp1hAU8znQ.jpg" },
        { book: "https://i.pinimg.com/736x/22/fd/25/22fd25dddb9acdf6a828ee27f184f250.jpg" },
        { book: "https://www.tregolam.com/wp-content/uploads/2016/03/Portada_Jacinto-Aran_Small.jpg" },
        { book: "https://images.cdn3.buscalibre.com/fit-in/360x360/61/8d/618d227e8967274cd9589a549adff52d.jpg" },
        { book: "https://marketplace.canva.com/EAF55Kx4v24/1/0/1003w/canva-portada-libro-fantas%C3%ADa-ilustrativo-verde-_pp1hAU8znQ.jpg" },
        { book: "https://i.pinimg.com/736x/22/fd/25/22fd25dddb9acdf6a828ee27f184f250.jpg" },
        { book: "https://www.tregolam.com/wp-content/uploads/2016/03/Portada_Jacinto-Aran_Small.jpg" },
        { book: "https://images.cdn3.buscalibre.com/fit-in/360x360/61/8d/618d227e8967274cd9589a549adff52d.jpg" },
        { book: "https://marketplace.canva.com/EAF55Kx4v24/1/0/1003w/canva-portada-libro-fantas%C3%ADa-ilustrativo-verde-_pp1hAU8znQ.jpg" },
        { book: "https://i.pinimg.com/736x/22/fd/25/22fd25dddb9acdf6a828ee27f184f250.jpg" }
    );
};

</script>

<template>
    <div>
        <div class="flex flex-row gap-20 items-center">
            <div class="header flex items-center">
                <i class="pi pi-fw pi-book" style="font-size:40px"></i>
                <label class="p-3" for="header"><b>Libros</b></label>
            </div>
            <input placeholder="Filtrar" type="filter_book" id="filter_book"
                class="header bg-[#EFE7D9] shadow appearance-none border-none rounded w-3xs py-4 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            <button class="header items-end  ml-auto p-3 rounded-md text-2xl h-full cursor-pointer">
                <label class="p-3 cursor-pointer" for="header">Agregar libro</label>
                <i class="pi pi-plus" style="font-size:25px"></i>
            </button>
        </div>
        <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4 mt-10 p-4">
            <div v-for="(item, index) in books" :key="index" class="p-4">
                <div class="flex flex-col">
                    <i class="pi pi-pencil ml-auto cursor-pointer " style="font-size:25px"></i>
                </div>
                <img :src="item.book" alt="Imagen"  class="mx-auto mt-2 w-32 h-40 object-cover rounded" />
            </div>
        </div>

    </div>
</template>

<style scoped>
.header {
    font-size: 1.6rem;
}
</style>