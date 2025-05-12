<script setup>
import { onMounted, ref } from 'vue'
import { Chart, registerables } from 'chart.js'

Chart.register(...registerables)

const canvasRefBar = ref(null)
const canvasRefLine = ref(null)
const canvasRefDoughnut = ref(null)
const canvasRefPie = ref(null)
const canvasRefRadar = ref(null)

onMounted(() => {
    new Chart(canvasRefBar.value, {
        type: 'bar',
        data: {
            labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo'],
            datasets: [{
                label: 'Nuevos usuarios',
                data: [10, 20, 30, 25, 21],
                backgroundColor: ['rgba(255, 206, 86, 0.6)'],
                borderColor: 'rgba(0, 0, 0, 0.1)',
                borderWidth: 1
            }]
        }
    })
    new Chart(canvasRefLine.value, {
        type: 'line',
        data: {
            labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo'],
            datasets: [{
                label: 'Prestamos realizados',
                data: [10, 20, 30, 25, 20],
                borderColor: 'blue',
                tension: 0.4,
                fill: true
            }]
        }
    })
    new Chart(canvasRefDoughnut.value, {
        type: 'doughnut',
        data: {
            labels: ['1 - 3 Años', '3 - 8 Años', 'Más de 8 Años'],
            datasets: [{
                label: 'Antiguedad de libros',
                data: [26, 14, 3],
                backgroundColor: ['rgba(239, 140, 22, 0.6)', 'rgba(141, 214, 174, 0.6)', 'rgba(99, 84, 210, 0.6)']
            }]
        }
    })
    new Chart(canvasRefPie.value, {
        type: 'pie',
        data: {
            labels: ['#1 Ciencia', '#2 Novelas', '#3 Matematicas'],
            datasets: [{
                data: [60, 32, 10],
                backgroundColor: ['orange', 'purple', 'gray']
            }]
        }
    })
    new Chart(canvasRefRadar.value, {
        type: 'radar',
        data: {
            labels: ['En reparación', 'Extraviados', 'No disponible', 'Dados de baja'],
            datasets: [{
                label: 'Estado de libros',
                data: [6, 7, 9, 13],
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'red'
            }]
        }
    })
})
</script>
<template>
    <div class="flex flex-row">
        <div class="w-full h-full border border-gray-400 p-3">
            <canvas ref="canvasRefBar"></canvas>
        </div>
        <div class="w-full h-full border border-gray-400 p-3">
            <canvas ref="canvasRefLine"></canvas>
        </div>
    </div>
    <div class="flex flex-row">
        <div class="w-full h-full border border-gray-400 p-3">
            <label class="title flex justify-center font-bold">Antiguedad de libros</label>
            <canvas ref="canvasRefDoughnut"></canvas>
        </div>
        <div class="w-full h-full border border-gray-400 p-3">
            <label class="title flex justify-center font-bold">TOP #3 categorías más solicitadas</label>
            <canvas ref="canvasRefPie"></canvas>
        </div>
    </div>
    <div class="flex flex-row">
        <div class="w-full h-full border border-gray-400 p-3">
            <canvas ref="canvasRefRadar"></canvas>
        </div>
    </div>

</template>
<style scoped>
.title {
    font-size: 1.5rem;
}
</style>
