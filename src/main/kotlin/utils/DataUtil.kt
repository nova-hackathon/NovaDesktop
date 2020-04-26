package utils

import common.DistanceInfo

//fun generateFakeData() = arrayListOf(
//    DistanceInfo(
//        "RED_002",
//        linkedMapOf(
//            "GRN_006" to 11500,
//            "RED_003" to 15250,
//            "GRN_001" to 1937,
//            "BLU_003" to 7625,
//            "GRN_003" to 9250,
//            "BLU_005" to 4750,
//            "BLU_006" to 12000,
//            "GRN_004" to 11062,
//            "BLU_002" to 19312,
//            "RED_005" to 4937,
//            "BLU_004" to 12125,
//            "RED_001" to 6250,
//            "GRN_005" to 12000,
//            "GRN_006" to 11500
//        )
//    ),
//    DistanceInfo(
//        "GRN_001", linkedMapOf(
//            "RED_003" to 15250,
//            "BLU_003" to 9000,
//            "GRN_003" to 12000,
//            "BLU_005" to 7750,
//            "BLU_006" to 12875,
//            "BLU_001" to 16312,
//            "RED_004" to 10187,
//            "GRN_004" to 10937,
//            "BLU_002" to 22500,
//            "RED_002" to 1750,
//            "BLU_004" to 12875,
//            "RED_001" to 9875,
//            "GRN_005" to 9125,
//            "GRN_006" to 13312
//        )
//    ),
//    DistanceInfo(
//        "BLU_005", linkedMapOf(
//            "RED_003" to 14687,
//            "GRN_003" to 4625,
//            "GRN_001" to 8062,
//            "BLU_003" to 4312,
//            "BLU_006" to 11812,
//            "BLU_001" to 8812,
//            "RED_004" to 10500,
//            "GRN_004" to 10750,
//            "BLU_002" to 15875,
//            "RED_005" to 6562,
//            "BLU_004" to 9875,
//            "RED_002" to 5062,
//            "RED_001" to 8687,
//            "GRN_006" to 10500,
//            "GRN_005" to 8687
//        )
//    ),
//    DistanceInfo(
//        "GRN_003", linkedMapOf(
//            "RED_003" to 15437,
//            "GRN_001" to 12250,
//            "BLU_003" to 6562,
//            "BLU_005" to 4625,
//            "BLU_006" to 12125,
//            "BLU_001" to 3437,
//            "RED_004" to 9250,
//            "GRN_004" to 15562,
//            "BLU_002" to 13750,
//            "RED_005" to 10500,
//            "RED_002" to 8687,
//            "BLU_004" to 8250,
//            "RED_001" to 15250,
//            "GRN_006" to 6562,
//            "GRN_005" to 15750
//        )
//    ),
//    DistanceInfo(
//        "BLU_001", linkedMapOf(
//            "RED_003" to 17687,
//            "GRN_001" to 15875,
//            "BLU_003" to 10500,
//            "GRN_003" to 4312,
//            "BLU_005" to 9125,
//            "BLU_006" to 15562,
//            "RED_004" to 12250,
//            "GRN_004" to 17812,
//            "BLU_002" to 10625,
//            "RED_005" to 10937,
//            "RED_002" to 10937,
//            "BLU_004" to 12000,
//            "RED_001" to 13937,
//            "GRN_006" to 6437,
//            "GRN_005" to 16937
//        )
//    ),
//    DistanceInfo(
//        "GRN_006", linkedMapOf(
//            "RED_003" to 19937,
//            "GRN_003" to 6562,
//            "BLU_005" to 7000,
//            "BLU_006" to 15250,
//            "BLU_001" to 6125,
//            "RED_004" to 11500,
//            "GRN_004" to 19625,
//            "BLU_002" to 11062,
//            "RED_005" to 11500,
//            "RED_002" to 11812,
//            "BLU_004" to 14812,
//            "RED_001" to 12562,
//            "GRN_005" to 8250,
//            "GRN_001" to 13312
//        )
//    ),
//    DistanceInfo(
//        "GRN_005", linkedMapOf(
//            "BLU_003" to 11500,
//            "GRN_001" to 12000,
//            "GRN_003" to 13187,
//            "BLU_005" to 8375,
//            "BLU_006" to 12125,
//            "BLU_001" to 14062,
//            "RED_004" to 14687,
//            "GRN_004" to 17375,
//            "RED_002" to 12000,
//            "BLU_004" to 16750,
//            "RED_001" to 14500,
//            "GRN_006" to 9875
//        )
//    ),
//    DistanceInfo(
//        "RED_005", linkedMapOf(
//            "BLU_003" to 10750,
//            "GRN_001" to 5375,
//            "GRN_003" to 11375,
//            "BLU_005" to 10500,
//            "BLU_006" to 18750,
//            "BLU_001" to 11812,
//            "RED_004" to 14375,
//            "GRN_004" to 11250,
//            "BLU_004" to 13937,
//            "RED_001" to 9562,
//            "GRN_005" to 7187,
//            "GRN_006" to 12437
//        )
//    ),
//    DistanceInfo(
//        "BLU_003", linkedMapOf(
//            "GRN_001" to 8375,
//            "GRN_003" to 7000,
//            "BLU_005" to 6125,
//            "BLU_006" to 7750,
//            "BLU_001" to 9562,
//            "RED_004" to 6250,
//            "GRN_004" to 9250,
//            "RED_005" to 11062,
//            "RED_002" to 7750,
//            "BLU_004" to 8375,
//            "RED_001" to 3000,
//            "GRN_005" to 12000,
//            "GRN_006" to 12875
//        )
//    ),
//    DistanceInfo(
//        "BLU_004", linkedMapOf(
//            "GRN_003" to 10750,
//            "GRN_001" to 15000,
//            "BLU_003" to 7625,
//            "BLU_005" to 11687,
//            "BLU_006" to 6750,
//            "BLU_001" to 12000,
//            "RED_004" to 7500,
//            "GRN_004" to 13312,
//            "RED_002" to 13000,
//            "RED_001" to 13187,
//            "GRN_006" to 14375,
//            "GRN_005" to 20687
//        )
//    ),
//    DistanceInfo(
//        "RED_004", linkedMapOf(
//            "BLU_003" to 6562,
//            "GRN_001" to 10000,
//            "GRN_003" to 9437,
//            "BLU_005" to 10312,
//            "BLU_006" to 2687,
//            "BLU_001" to 12125,
//            "GRN_004" to 10937,
//            "RED_005" to 14062,
//            "RED_002" to 11062,
//            "BLU_004" to 7625,
//            "RED_001" to 6562,
//            "GRN_005" to 16750,
//            "GRN_006" to 11500
//        )
//    ),
//    DistanceInfo(
//        "RED_001", linkedMapOf(
//            "BLU_003" to 3750,
//            "GRN_001" to 7937,
//            "GRN_003" to 13000,
//            "BLU_005" to 9000,
//            "BLU_006" to 7312,
//            "BLU_001" to 12437,
//            "RED_004" to 6000,
//            "GRN_004" to 6437,
//            "RED_002" to 7500,
//            "BLU_004" to 13500,
//            "GRN_005" to 13937,
//            "GRN_006" to 13312
//        )
//    ),
//    DistanceInfo(
//        "GRN_004", linkedMapOf(
//            "BLU_003" to 8062,
//            "GRN_001" to 10625,
//            "GRN_003" to 15750,
//            "BLU_005" to 11687,
//            "BLU_006" to 7312,
//            "BLU_001" to 18875,
//            "RED_004" to 14062,
//            "RED_005" to 11375,
//            "RED_002" to 11250,
//            "BLU_004" to 13000,
//            "RED_001" to 6437,
//            "GRN_005" to 16937,
//            "GRN_006" to 17500
//        )
//    ),
//    DistanceInfo(
//        "BLU_006", linkedMapOf(
//            "BLU_003" to 8500,
//            "GRN_001" to 12250,
//            "GRN_003" to 10750,
//            "BLU_005" to 11500
//        )
//    )
//)

//fun generateDictionaryForMap() = linkedMapOf<String, DistanceInfo>(
//    "RED_002" to DistanceInfo(
//        "RED_002",
//        linkedMapOf(
//            "GRN_001" to 1843,
//            "BLU_003" to 7687,
//            "GRN_003" to 8968,
//            "BLU_005" to 4906,
//            "BLU_006" to 12000,
//            "BLU_001" to 10937,
//            "RED_004" to 11062,
//            "GRN_004" to 11156,
//            "RED_005" to 4937,
//            "BLU_004" to 12562,
//            "RED_001" to 6875,
//            "GRN_005" to 12000,
//            "GRN_006" to 11656
//        )
//    ),
//    "GRN_001" to DistanceInfo(
//        "GRN_001",
//        linkedMapOf(
//            "BLU_003" to 8687,
//            "GRN_003" to 12125,
//            "BLU_005" to 7906,
//            "BLU_006" to 12562,
//            "BLU_001" to 16093,
//            "RED_004" to 10093,
//            "GRN_004" to 10781,
//            "RED_005" to 5375,
//            "RED_002" to 1843,
//            "BLU_004" to 13937,
//            "RED_001" to 8906,
//            "GRN_005" to 10562,
//            "GRN_006" to 13312
//        )
//    ),
//
//    "BLU_005" to DistanceInfo(
//        "BLU_005",
//        linkedMapOf(
//            "GRN_003" to 4625,
//            "GRN_001" to 7906,
//            "BLU_003" to 5218,
//            "BLU_006" to 11656,
//            "BLU_001" to 8968,
//            "RED_004" to 10406,
//            "GRN_004" to 11218,
//            "RED_005" to 8531,
//            "BLU_004" to 10781,
//            "RED_002" to 4906,
//            "RED_001" to 8843,
//            "GRN_006" to 8750,
//            "GRN_005" to 8531
//        )
//    ),
//    "GRN_003" to DistanceInfo(
//        "GRN_003",
//        linkedMapOf(
//            "GRN_001" to 12125,
//            "BLU_003" to 6781,
//            "BLU_005" to 4625,
//            "BLU_006" to 11437,
//            "BLU_001" to 3874,
//            "RED_004" to 9343,
//            "GRN_004" to 15656,
//            "RED_005" to 10937,
//            "RED_002" to 8968,
//            "BLU_004" to 9500,
//            "RED_001" to 14125,
//            "GRN_006" to 6562,
//            "GRN_005" to 14468
//        )
//    ),
//    "BLU_001" to DistanceInfo(
//        "BLU_001",
//        linkedMapOf(
//            "GRN_001" to 16093,
//            "BLU_003" to 10031,
//            "GRN_003" to 3874,
//            "BLU_005" to 8968,
//            "BLU_006" to 15562,
//            "RED_004" to 12187,
//            "GRN_004" to 18343,
//            "RED_005" to 11374,
//            "RED_002" to 10937,
//            "BLU_004" to 12000,
//            "RED_001" to 13187,
//            "GRN_006" to 6281,
//            "GRN_005" to 15499
//        )
//    ),
//    "GRN_006" to DistanceInfo(
//        "GRN_006",
//        linkedMapOf(
//            "BLU_003" to 12875,
//            "GRN_001" to 13312,
//            "GRN_003" to 6562,
//            "BLU_005" to 8750,
//            "BLU_006" to 15250,
//            "BLU_001" to 6281,
//            "RED_004" to 11500,
//            "GRN_004" to 18562,
//            "RED_005" to 11968,
//            "RED_002" to 11656,
//            "BLU_004" to 14593,
//            "RED_001" to 12937,
//            "GRN_005" to 9062
//        )
//    ),
//    "GRN_005" to DistanceInfo(
//        "GRN_005",
//        linkedMapOf(
//            "BLU_003" to 11750,
//            "GRN_001" to 10562,
//            "GRN_003" to 14468,
//            "BLU_005" to 8531,
//            "BLU_006" to 12125,
//            "BLU_001" to 15499,
//            "RED_004" to 15718,
//            "GRN_004" to 17156,
//            "RED_005" to 7187,
//            "RED_002" to 12000,
//            "BLU_004" to 18718,
//            "RED_001" to 14218,
//            "GRN_006" to 9062
//        )
//    ),
//    "RED_005" to DistanceInfo(
//        "RED_005",
//        linkedMapOf(
//            "BLU_003" to 10906,
//            "GRN_001" to 5375,
//            "GRN_003" to 10937,
//            "BLU_005" to 8531,
//            "BLU_006" to 18750,
//            "BLU_001" to 11374,
//            "RED_004" to 14218,
//            "GRN_004" to 11312,
//            "RED_002" to 4937,
//            "BLU_004" to 13937,
//            "RED_001" to 9562,
//            "GRN_005" to 7187,
//            "GRN_006" to 11968
//        )
//    ),
//    "BLU_003" to DistanceInfo(
//        "BLU_003",
//        linkedMapOf(
//            "GRN_001" to 8687,
//            "GRN_003" to 6781,
//            "BLU_005" to 5218,
//            "BLU_006" to 8125,
//            "BLU_001" to 10031,
//            "RED_004" to 6406,
//            "GRN_004" to 8656,
//            "RED_005" to 10906,
//            "RED_002" to 7687,
//            "BLU_004" to 8000,
//            "RED_001" to 3375,
//            "GRN_005" to 11750,
//            "GRN_006" to 12875
//        )
//    ),
//    "BLU_004" to DistanceInfo(
//        "BLU_004",
//        linkedMapOf(
//            "GRN_003" to 9500,
//            "GRN_001" to 13937,
//            "BLU_003" to 8000,
//            "BLU_005" to 10781,
//            "BLU_006" to 6750,
//            "BLU_001" to 12000,
//            "RED_004" to 7562,
//            "GRN_004" to 13156,
//            "RED_005" to 13937,
//            "RED_002" to 12562,
//            "RED_001" to 13343,
//            "GRN_006" to 14593,
//            "GRN_005" to 18718
//        )
//    ),
//    "RED_004" to DistanceInfo(
//        "RED_004",
//        linkedMapOf(
//            "BLU_003" to 6406,
//            "GRN_001" to 10093,
//            "GRN_003" to 9343,
//            "BLU_005" to 10406,
//            "BLU_006" to 2687,
//            "BLU_001" to 12187,
//            "GRN_004" to 12499,
//            "RED_005" to 14218,
//            "RED_002" to 11062,
//            "BLU_004" to 7562,
//            "RED_001" to 6281,
//            "GRN_005" to 15718,
//            "GRN_006" to 11500
//        )
//    ),
//    "RED_001" to DistanceInfo(
//        "RED_001",
//        linkedMapOf(
//            "BLU_003" to 3375,
//            "GRN_001" to 8906,
//            "GRN_003" to 14125,
//            "BLU_005" to 8843,
//            "BLU_006" to 7312,
//            "BLU_001" to 13187,
//            "RED_004" to 6281,
//            "GRN_004" to 6437,
//            "RED_005" to 9562,
//            "RED_002" to 6875,
//            "BLU_004" to 13343,
//            "GRN_005" to 14218,
//            "GRN_006" to 12937
//        )
//    ),
//    "GRN_004" to DistanceInfo(
//        "GRN_004",
//        linkedMapOf(
//            "BLU_003" to 8656,
//            "GRN_001" to 10781,
//            "GRN_003" to 15656,
//            "BLU_005" to 11218,
//            "BLU_006" to 7312,
//            "BLU_001" to 18343,
//            "RED_004" to 12499,
//            "RED_005" to 11312,
//            "RED_002" to 11156,
//            "BLU_004" to 13156,
//            "RED_001" to 6437,
//            "GRN_005" to 17156,
//            "GRN_006" to 18562
//        )
//    ),
//    "BLU_006" to DistanceInfo(
//        "BLU_006",
//        linkedMapOf(
//            "BLU_003" to 8125,
//            "GRN_001" to 12562,
//            "GRN_003" to 11437,
//            "BLU_005" to 11656,
//            "BLU_001" to 15562,
//            "RED_004" to 2687,
//            "GRN_004" to 7312,
//            "RED_005" to 18750,
//            "RED_002" to 12000,
//            "BLU_004" to 6750,
//            "RED_001" to 7312,
//            "GRN_005" to 12125,
//            "GRN_006" to 15250
//        )
//    )
//)

fun generateExampleJson() = "{\"list\":[\n" +
        "    {\"distanceList\":[{\"distance\":15250,\"phoneName\":\"RED_003\"},{\"distance\":1937,\"phoneName\":\"GRN_001\"},{\"distance\":7625,\"phoneName\":\"BLU_003\"},{\"distance\":9250,\"phoneName\":\"GRN_003\"},{\"distance\":4750,\"phoneName\":\"BLU_005\"},{\"distance\":12000,\"phoneName\":\"BLU_006\"},{\"distance\":-1,\"phoneName\":\"BLU_001\"},{\"distance\":-1,\"phoneName\":\"RED_004\"},{\"distance\":11062,\"phoneName\":\"GRN_004\"},{\"distance\":19312,\"phoneName\":\"BLU_002\"},{\"distance\":4937,\"phoneName\":\"RED_005\"},{\"distance\":12125,\"phoneName\":\"BLU_004\"},{\"distance\":6250,\"phoneName\":\"RED_001\"},{\"distance\":12000,\"phoneName\":\"GRN_005\"},{\"distance\":11500,\"phoneName\":\"GRN_006\"}],\"phoneId\":\"8f5a324642c0fed9\",\"phoneName\":\"RED_002\"},\n" +
        "    {\"distanceList\":[{\"distance\":15250,\"phoneName\":\"RED_003\"},{\"distance\":9000,\"phoneName\":\"BLU_003\"},{\"distance\":12000,\"phoneName\":\"GRN_003\"},{\"distance\":7750,\"phoneName\":\"BLU_005\"},{\"distance\":12875,\"phoneName\":\"BLU_006\"},{\"distance\":16312,\"phoneName\":\"BLU_001\"},{\"distance\":10187,\"phoneName\":\"RED_004\"},{\"distance\":10937,\"phoneName\":\"GRN_004\"},{\"distance\":22500,\"phoneName\":\"BLU_002\"},{\"distance\":-1,\"phoneName\":\"RED_005\"},{\"distance\":1750,\"phoneName\":\"RED_002\"},{\"distance\":12875,\"phoneName\":\"BLU_004\"},{\"distance\":9875,\"phoneName\":\"RED_001\"},{\"distance\":9125,\"phoneName\":\"GRN_005\"},{\"distance\":13312,\"phoneName\":\"GRN_006\"}],\"phoneId\":\"f479816dcb1e7cef\",\"phoneName\":\"GRN_001\"},\n" +
        "    {\"distanceList\":[{\"distance\":14687,\"phoneName\":\"RED_003\"},{\"distance\":4625,\"phoneName\":\"GRN_003\"},{\"distance\":8062,\"phoneName\":\"GRN_001\"},{\"distance\":4312,\"phoneName\":\"BLU_003\"},{\"distance\":11812,\"phoneName\":\"BLU_006\"},{\"distance\":8812,\"phoneName\":\"BLU_001\"},{\"distance\":10500,\"phoneName\":\"RED_004\"},{\"distance\":10750,\"phoneName\":\"GRN_004\"},{\"distance\":15875,\"phoneName\":\"BLU_002\"},{\"distance\":6562,\"phoneName\":\"RED_005\"},{\"distance\":9875,\"phoneName\":\"BLU_004\"},{\"distance\":5062,\"phoneName\":\"RED_002\"},{\"distance\":8687,\"phoneName\":\"RED_001\"},{\"distance\":10500,\"phoneName\":\"GRN_006\"},{\"distance\":8687,\"phoneName\":\"GRN_005\"}],\"phoneId\":\"d67602abeac3b4d5\",\"phoneName\":\"BLU_005\"},\n" +
        "    {\"distanceList\":[{\"distance\":15437,\"phoneName\":\"RED_003\"},{\"distance\":12250,\"phoneName\":\"GRN_001\"},{\"distance\":6562,\"phoneName\":\"BLU_003\"},{\"distance\":4625,\"phoneName\":\"BLU_005\"},{\"distance\":12125,\"phoneName\":\"BLU_006\"},{\"distance\":3437,\"phoneName\":\"BLU_001\"},{\"distance\":9250,\"phoneName\":\"RED_004\"},{\"distance\":15562,\"phoneName\":\"GRN_004\"},{\"distance\":13750,\"phoneName\":\"BLU_002\"},{\"distance\":10500,\"phoneName\":\"RED_005\"},{\"distance\":8687,\"phoneName\":\"RED_002\"},{\"distance\":8250,\"phoneName\":\"BLU_004\"},{\"distance\":15250,\"phoneName\":\"RED_001\"},{\"distance\":6562,\"phoneName\":\"GRN_006\"},{\"distance\":15750,\"phoneName\":\"GRN_005\"}],\"phoneId\":\"20406a14c8bfbadf\",\"phoneName\":\"GRN_003\"},\n" +
        "    {\"distanceList\":[{\"distance\":17687,\"phoneName\":\"RED_003\"},{\"distance\":15875,\"phoneName\":\"GRN_001\"},{\"distance\":10500,\"phoneName\":\"BLU_003\"},{\"distance\":4312,\"phoneName\":\"GRN_003\"},{\"distance\":9125,\"phoneName\":\"BLU_005\"},{\"distance\":15562,\"phoneName\":\"BLU_006\"},{\"distance\":12250,\"phoneName\":\"RED_004\"},{\"distance\":17812,\"phoneName\":\"GRN_004\"},{\"distance\":10625,\"phoneName\":\"BLU_002\"},{\"distance\":10937,\"phoneName\":\"RED_005\"},{\"distance\":10937,\"phoneName\":\"RED_002\"},{\"distance\":12000,\"phoneName\":\"BLU_004\"},{\"distance\":13937,\"phoneName\":\"RED_001\"},{\"distance\":6437,\"phoneName\":\"GRN_006\"},{\"distance\":16937,\"phoneName\":\"GRN_005\"}],\"phoneId\":\"4660bb64cd2ea3de\",\"phoneName\":\"BLU_001\"},\n" +
        "    {\"distanceList\":[{\"distance\":19937,\"phoneName\":\"RED_003\"},{\"distance\":-1,\"phoneName\":\"BLU_003\"},{\"distance\":-1,\"phoneName\":\"GRN_001\"},{\"distance\":6562,\"phoneName\":\"GRN_003\"},{\"distance\":7000,\"phoneName\":\"BLU_005\"},{\"distance\":15250,\"phoneName\":\"BLU_006\"},{\"distance\":6125,\"phoneName\":\"BLU_001\"},{\"distance\":11500,\"phoneName\":\"RED_004\"},{\"distance\":19625,\"phoneName\":\"GRN_004\"},{\"distance\":11062,\"phoneName\":\"BLU_002\"},{\"distance\":11500,\"phoneName\":\"RED_005\"},{\"distance\":11812,\"phoneName\":\"RED_002\"},{\"distance\":14812,\"phoneName\":\"BLU_004\"},{\"distance\":12562,\"phoneName\":\"RED_001\"},{\"distance\":8250,\"phoneName\":\"GRN_005\"}],\"phoneId\":\"8ff88453091a54aa\",\"phoneName\":\"GRN_006\"},\n" +
        "    {\"distanceList\":[{\"distance\":-1,\"phoneName\":\"GRN_002\"},{\"distance\":-1,\"phoneName\":\"RED_003\"},{\"distance\":11500,\"phoneName\":\"BLU_003\"},{\"distance\":12000,\"phoneName\":\"GRN_001\"},{\"distance\":13187,\"phoneName\":\"GRN_003\"},{\"distance\":8375,\"phoneName\":\"BLU_005\"},{\"distance\":12125,\"phoneName\":\"BLU_006\"},{\"distance\":14062,\"phoneName\":\"BLU_001\"},{\"distance\":14687,\"phoneName\":\"RED_004\"},{\"distance\":17375,\"phoneName\":\"GRN_004\"},{\"distance\":-1,\"phoneName\":\"BLU_002\"},{\"distance\":-1,\"phoneName\":\"RED_005\"},{\"distance\":12000,\"phoneName\":\"RED_002\"},{\"distance\":16750,\"phoneName\":\"BLU_004\"},{\"distance\":14500,\"phoneName\":\"RED_001\"},{\"distance\":9875,\"phoneName\":\"GRN_006\"}],\"phoneId\":\"278df967ee664c3c\",\"phoneName\":\"GRN_005\"},\n" +
        "    {\"distanceList\":[{\"distance\":-1,\"phoneName\":\"GRN_002\"},{\"distance\":-1,\"phoneName\":\"RED_003\"},{\"distance\":10750,\"phoneName\":\"BLU_003\"},{\"distance\":5375,\"phoneName\":\"GRN_001\"},{\"distance\":11375,\"phoneName\":\"GRN_003\"},{\"distance\":10500,\"phoneName\":\"BLU_005\"},{\"distance\":18750,\"phoneName\":\"BLU_006\"},{\"distance\":11812,\"phoneName\":\"BLU_001\"},{\"distance\":14375,\"phoneName\":\"RED_004\"},{\"distance\":11250,\"phoneName\":\"GRN_004\"},{\"distance\":-1,\"phoneName\":\"BLU_002\"},{\"distance\":-1,\"phoneName\":\"RED_002\"},{\"distance\":13937,\"phoneName\":\"BLU_004\"},{\"distance\":9562,\"phoneName\":\"RED_001\"},{\"distance\":7187,\"phoneName\":\"GRN_005\"},{\"distance\":12437,\"phoneName\":\"GRN_006\"}],\"phoneId\":\"81dec5983097638b\",\"phoneName\":\"RED_005\"},\n" +
        "    {\"distanceList\":[{\"distance\":-1,\"phoneName\":\"GRN_002\"},{\"distance\":-1,\"phoneName\":\"RED_003\"},{\"distance\":8375,\"phoneName\":\"GRN_001\"},{\"distance\":7000,\"phoneName\":\"GRN_003\"},{\"distance\":6125,\"phoneName\":\"BLU_005\"},{\"distance\":7750,\"phoneName\":\"BLU_006\"},{\"distance\":9562,\"phoneName\":\"BLU_001\"},{\"distance\":6250,\"phoneName\":\"RED_004\"},{\"distance\":9250,\"phoneName\":\"GRN_004\"},{\"distance\":-1,\"phoneName\":\"BLU_002\"},{\"distance\":11062,\"phoneName\":\"RED_005\"},{\"distance\":7750,\"phoneName\":\"RED_002\"},{\"distance\":8375,\"phoneName\":\"BLU_004\"},{\"distance\":3000,\"phoneName\":\"RED_001\"},{\"distance\":12000,\"phoneName\":\"GRN_005\"},{\"distance\":12875,\"phoneName\":\"GRN_006\"}],\"phoneId\":\"a16fc2a0628bbd1a\",\"phoneName\":\"BLU_003\"},\n" +
        "    {\"distanceList\":[{\"distance\":-1,\"phoneName\":\"GRN_002\"},{\"distance\":-1,\"phoneName\":\"RED_003\"},{\"distance\":10750,\"phoneName\":\"GRN_003\"},{\"distance\":15000,\"phoneName\":\"GRN_001\"},{\"distance\":7625,\"phoneName\":\"BLU_003\"},{\"distance\":11687,\"phoneName\":\"BLU_005\"},{\"distance\":6750,\"phoneName\":\"BLU_006\"},{\"distance\":12000,\"phoneName\":\"BLU_001\"},{\"distance\":7500,\"phoneName\":\"RED_004\"},{\"distance\":13312,\"phoneName\":\"GRN_004\"},{\"distance\":-1,\"phoneName\":\"BLU_002\"},{\"distance\":-1,\"phoneName\":\"RED_005\"},{\"distance\":13000,\"phoneName\":\"RED_002\"},{\"distance\":13187,\"phoneName\":\"RED_001\"},{\"distance\":14375,\"phoneName\":\"GRN_006\"},{\"distance\":20687,\"phoneName\":\"GRN_005\"}],\"phoneId\":\"6a3c20baf3fd5992\",\"phoneName\":\"BLU_004\"},\n" +
        "    {\"distanceList\":[{\"distance\":-1,\"phoneName\":\"GRN_002\"},{\"distance\":-1,\"phoneName\":\"RED_003\"},{\"distance\":6562,\"phoneName\":\"BLU_003\"},{\"distance\":10000,\"phoneName\":\"GRN_001\"},{\"distance\":9437,\"phoneName\":\"GRN_003\"},{\"distance\":10312,\"phoneName\":\"BLU_005\"},{\"distance\":2687,\"phoneName\":\"BLU_006\"},{\"distance\":12125,\"phoneName\":\"BLU_001\"},{\"distance\":10937,\"phoneName\":\"GRN_004\"},{\"distance\":-1,\"phoneName\":\"BLU_002\"},{\"distance\":14062,\"phoneName\":\"RED_005\"},{\"distance\":11062,\"phoneName\":\"RED_002\"},{\"distance\":7625,\"phoneName\":\"BLU_004\"},{\"distance\":6562,\"phoneName\":\"RED_001\"},{\"distance\":16750,\"phoneName\":\"GRN_005\"},{\"distance\":11500,\"phoneName\":\"GRN_006\"}],\"phoneId\":\"4d45fc0139abfda2\",\"phoneName\":\"RED_004\"},\n" +
        "    {\"distanceList\":[{\"distance\":-1,\"phoneName\":\"GRN_002\"},{\"distance\":-1,\"phoneName\":\"RED_003\"},{\"distance\":3750,\"phoneName\":\"BLU_003\"},{\"distance\":7937,\"phoneName\":\"GRN_001\"},{\"distance\":13000,\"phoneName\":\"GRN_003\"},{\"distance\":9000,\"phoneName\":\"BLU_005\"},{\"distance\":7312,\"phoneName\":\"BLU_006\"},{\"distance\":12437,\"phoneName\":\"BLU_001\"},{\"distance\":6000,\"phoneName\":\"RED_004\"},{\"distance\":6437,\"phoneName\":\"GRN_004\"},{\"distance\":-1,\"phoneName\":\"BLU_002\"},{\"distance\":-1,\"phoneName\":\"RED_005\"},{\"distance\":7500,\"phoneName\":\"RED_002\"},{\"distance\":13500,\"phoneName\":\"BLU_004\"},{\"distance\":13937,\"phoneName\":\"GRN_005\"},{\"distance\":13312,\"phoneName\":\"GRN_006\"}],\"phoneId\":\"852b4ece1b7ece7c\",\"phoneName\":\"RED_001\"},\n" +
        "    {\"distanceList\":[{\"distance\":-1,\"phoneName\":\"GRN_002\"},{\"distance\":-1,\"phoneName\":\"RED_003\"},{\"distance\":8062,\"phoneName\":\"BLU_003\"},{\"distance\":10625,\"phoneName\":\"GRN_001\"},{\"distance\":15750,\"phoneName\":\"GRN_003\"},{\"distance\":11687,\"phoneName\":\"BLU_005\"},{\"distance\":7312,\"phoneName\":\"BLU_006\"},{\"distance\":18875,\"phoneName\":\"BLU_001\"},{\"distance\":14062,\"phoneName\":\"RED_004\"},{\"distance\":-1,\"phoneName\":\"BLU_002\"},{\"distance\":11375,\"phoneName\":\"RED_005\"},{\"distance\":11250,\"phoneName\":\"RED_002\"},{\"distance\":13000,\"phoneName\":\"BLU_004\"},{\"distance\":6437,\"phoneName\":\"RED_001\"},{\"distance\":16937,\"phoneName\":\"GRN_005\"},{\"distance\":17500,\"phoneName\":\"GRN_006\"}],\"phoneId\":\"3e6c05cfba977851\",\"phoneName\":\"GRN_004\"},\n" +
        "    {\"distanceList\":[{\"distance\":-1,\"phoneName\":\"GRN_002\"},{\"distance\":-1,\"phoneName\":\"RED_003\"},{\"distance\":8500,\"phoneName\":\"BLU_003\"},{\"distance\":12250,\"phoneName\":\"GRN_001\"},{\"distance\":10750,\"phoneName\":\"GRN_003\"},{\"distance\":11500,\"phoneName\":\"BLU_005\"},{\"distance\":-1,\"phoneName\":\"BLU_001\"},{\"distance\":-1,\"phoneName\":\"RED_004\"},{\"distance\":-1,\"phoneName\":\"GRN_004\"},{\"distance\":-1,\"phoneName\":\"BLU_002\"},{\"distance\":-1,\"phoneName\":\"RED_005\"},{\"distance\":-1,\"phoneName\":\"RED_002\"},{\"distance\":-1,\"phoneName\":\"BLU_004\"},{\"distance\":-1,\"phoneName\":\"RED_001\"},{\"distance\":-1,\"phoneName\":\"GRN_005\"},{\"distance\":-1,\"phoneName\":\"GRN_006\"}],\"phoneId\":\"e3225688d4772302\",\"phoneName\":\"BLU_006\"},\n" +
        "    {\"distanceList\":[],\"phoneId\":\"747581e7a57405c3\",\"phoneName\":\"RED_003\"}\n" +
        "]}"
