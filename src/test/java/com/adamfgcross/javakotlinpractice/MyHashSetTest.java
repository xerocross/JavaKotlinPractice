package com.adamfgcross.javakotlinpractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyHashSetTest {

    @Test
    public void canBuildHashMap() {
        assertDoesNotThrow(()->{
            MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        });
    }

    @Test
    public void canAddElementToHashMap() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        myHashSet.add(5);
    }

    @Test
    public void afterAddingElementContainsIsPositive() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        myHashSet.add(5);
        assertTrue(myHashSet.contains(5));
    }

    @Test
    public void ifElementNotAddedContainsReturnsFalse() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        myHashSet.add(3);
        assertFalse(myHashSet.contains(5));
    }

    @Test
    public void forEmptySetSizeIs0() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        assertEquals(0, myHashSet.size());
    }

    @Test
    public void forEmptySetIsEmptyReturnsTrue() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        assertTrue(myHashSet.isEmpty());
    }

    @Test
    public void afterAddingSeveralDistinctElementsSizeIsCorrect() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        int[] elements = new int[] {5, 17, 33, 134, 72, 88, 99, 9, 12};
        for (int i : elements) {
            myHashSet.add(i);
        }
        assertEquals(elements.length, myHashSet.size());
    }

    @Test
    public void afterAddingSeveralElementsWithDupesSizeIsCorrect() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        int[] elements = new int[] {5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12};
        int numDupes = 3;
        for (int i : elements) {
            myHashSet.add(i);
        }
        assertEquals(elements.length - numDupes, myHashSet.size());
    }

    @Test
    public void afterAddingSeveralElementsContainsWorksOnRandom() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        int[] elements = new int[] {5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12};
        for (int i : elements) {
            myHashSet.add(i);
        }
        int index = new Random().nextInt(elements.length);
        int element = elements[index];
        assertTrue(myHashSet.contains(element));
    }

    @Test
    public void afterAddingSeveralElementsContainsWorksOnRandom2() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        int[] elements = new int[] {7627, 6896, 1968, 3314, 143, 1247, 8603, 4857, 1869, 9782, 1604, 8705, 1568, 6327, 7346, 890, 6416, 9558, 9580, 3047, 2269, 2005, 3103, 3757, 1884, 2869, 2928, 1140, 7124, 1739, 8372, 2385, 9796, 8079, 420, 6174, 3656, 5847, 9541, 5111, 3892, 5880, 3735, 1139, 8451, 3191, 1220, 2694, 9538, 3873, 3224, 9402, 8903, 4715, 5023, 4554, 3734, 779, 2668, 602, 3767, 2584, 7653, 9928, 4030, 3986, 5211, 9321, 7897, 9926, 6900, 8977, 1862, 8180, 6619, 326, 7824, 6998, 977, 4690, 4358, 5221, 4318, 1300, 6497, 4261, 4924, 8148, 2085, 1153, 7155, 1915, 3585, 4287, 1354, 7256, 9361, 5724, 9111, 9387, 2844, 7352, 9080, 7823, 2340, 3284, 7692, 1029, 6260, 3309, 5889, 1788, 4532, 471, 40, 6917, 5696, 8618, 1026, 8194, 4755, 7973, 6134, 6318, 5319, 9928, 6052, 6352, 5260, 3892, 7203, 319, 2034, 7700, 3041, 8718, 3817, 1026, 8986, 3351, 9733, 3556, 6884, 2908, 2013, 2253, 411, 5812, 6574, 6549, 5366, 8075, 6280, 5658, 9270, 4043, 9967, 4382, 96, 9476, 5050, 1861, 9232, 5313, 4080, 9980, 4224, 975, 2553, 7244, 5496, 5663, 2300, 1641, 1726, 8364, 4485, 6612, 4804, 35, 1145, 1530, 2208, 1998, 9032, 7301, 7810, 4507, 4053, 163, 3748, 4754, 4527, 4497, 82, 6233, 7648, 6974, 4467, 8911, 4909, 7553, 7212, 150, 975, 1170, 3082, 7473, 2494, 579, 2315, 5080, 7195, 8623, 9756, 9516, 4094, 7764, 494, 4801, 4467, 8852, 9921, 5268, 812, 90, 9236, 6188, 5347, 4293, 8368, 3999, 7793, 5710, 3592, 6176, 7238, 3481, 2660, 6978, 3583, 8483, 6293, 5394, 1967, 4036, 8918, 6495, 9967, 3788, 1609, 9427, 4024, 6463, 9948, 1247, 272, 6213, 8729, 5850, 1105, 4903, 9506, 2351, 6521, 6788, 1964, 8076, 6191, 8177, 1997, 2277, 5395, 4514, 4133, 1583, 8025, 719, 6192, 7807, 2151, 7418, 9454, 9543, 3269, 8569, 3582, 2107, 8378, 2500, 7035, 6803, 2823, 5660, 5214, 8898, 2774, 4631, 3931, 1931, 8038, 9824, 6976, 9140, 5874, 6685, 8490, 6107, 7120, 7265, 4175, 7428, 3505, 975, 3110, 7525, 4600, 7886, 8339, 2845, 2978, 9326, 8783, 2410, 3254, 5311, 7584, 2009, 8594, 7402, 9780, 6704, 4968, 2715, 2344, 6092, 178, 3949, 9307, 2381, 5507, 1727, 9641, 1816, 2294, 3928, 1010, 8075, 2555, 3498, 6860, 848, 8732, 3536, 281, 9734, 7608, 9431, 4589, 7290, 6463, 5382, 6998, 2051, 7644, 7139, 1108, 8194, 1245, 9187, 2643, 7069, 4400, 7639, 5287, 6568, 6886, 1484, 7412, 6634, 5567, 7389, 5217, 4130, 2378, 9157, 1228, 1455, 385, 6091, 3779, 1522, 7749, 2472, 5210, 1701, 1475, 8755, 8017, 436, 8394, 5922, 8913, 5469, 7825, 2964, 146, 9121, 3947, 7808, 7715, 3038, 406, 5180, 9615, 4082, 7332, 1406, 2166, 6411, 2391, 571, 2801, 6527, 7127, 8295, 1715, 9494, 7410, 7632, 6992, 6350, 1601, 3765, 5822, 8966, 5344, 6726, 2924, 8701, 8264, 7723, 7504, 9597, 3330, 7564, 9314, 5952, 6495, 2371, 1089, 5926, 3570, 7166, 9486, 6074, 6888, 6607, 3795, 2808, 7481, 6234, 9361, 2652, 7755, 4771, 6075, 4857, 2179, 5842, 4360, 2825, 2766, 2084, 361, 9430, 3979, 497, 5137, 1010, 2092, 3437, 9292, 3867, 3714, 6592, 7371, 91, 3444, 4903, 4751, 1433, 4021, 3967, 6123, 2070, 3046, 1811, 8089, 3819, 1088, 8944, 683, 2376, 8562, 4223, 6498, 8703, 2676, 1273, 697, 8525, 5028, 2952, 58, 4405, 877, 1951, 7042, 9201, 9153, 5031, 3667, 3109, 2558, 4521, 242, 4932, 3846, 2017, 8653, 9683, 5063, 8746, 7275, 585, 5132, 6647, 8429, 5714, 9871, 8210, 6329, 3379, 58, 8520, 5328, 6987, 9700, 8084, 9935, 1683, 3084, 6311, 3900, 1326, 4469, 530, 2975, 7177, 2982, 3452, 7048, 5602, 9562, 3973, 6652, 4912, 1478, 8992, 839, 591, 3128, 9497, 4523, 6972, 1732, 2612, 3959, 9286, 7640, 6080, 2443, 80, 5946, 1612, 6003, 4424, 1099, 4187, 4810, 6226, 8519, 3022, 376, 7943, 7770, 2793, 8721, 4944, 1519, 403, 689, 7250, 9325, 468, 3165, 2483, 8568, 140, 3600, 4177, 899, 9217, 844, 7253, 335, 327, 6713, 9685, 1169, 967, 2383, 3889, 1103, 9140, 6414, 7930, 4344, 5505, 9950, 1491, 9892, 7185, 8477, 5692, 5235, 9338, 7886, 7209, 9842, 5545, 6655, 5160, 2155, 3999, 5970, 1441, 5227, 7333, 2659, 7104, 2733, 4078, 6644, 2376, 9064, 7874, 4947, 9818, 7884, 9773, 4687, 1383, 3424, 4061, 7923, 9881, 388, 6536, 860, 2775, 8502, 5321, 6825, 806, 2100, 5721, 3075, 3132, 9751, 4347, 3737, 9139, 9794, 6000, 2840, 6331, 2970, 4347, 4071, 6114, 8368, 7434, 4875, 3481, 7214, 8065, 1683, 1727, 2136, 1570, 400, 4208, 4224, 896, 5643, 2983, 2415, 9032, 2250, 6485, 7925, 9715, 262, 1545, 5806, 6182, 8753, 3776, 252, 5145, 5905, 7512, 2652, 722, 1532, 1724, 1408, 684, 7130, 3904, 6213, 2348, 1155, 9759, 7847, 1366, 9909, 7553, 4772, 2884, 4844, 5128, 7694, 1622, 6170, 9817, 9645, 1359, 492, 6319, 7186, 6766, 5486, 5561, 3091, 1932, 4556, 2376, 2915, 1696, 2840, 440, 5151, 1140, 1509, 1200, 8368, 9208, 4988, 9227, 2124, 1859, 9863, 4528, 7224, 2478, 2766, 2475, 8567, 720, 5591, 2055, 8538, 9555, 6388, 9271, 9555, 3174, 1670, 7958, 4492, 3571, 2849, 2455, 2267, 7072, 9925, 9976, 6090, 3305, 8175, 1454, 4427, 1539, 6885, 3596, 9694, 5894, 9414, 8073, 9042, 8104, 1578, 7175, 3062, 9450, 7735, 4167, 2074, 3908, 2580, 8627, 8397, 1656, 4507, 6315, 9304, 6386, 716, 1343, 9883, 8390, 8345, 9583, 9448, 2287, 4167, 8564, 6707, 6331, 4436, 9103, 1426, 5839, 1537, 6962, 6978, 4601, 1092, 3391, 7442, 7379, 4278, 7255, 9345, 9321, 1221, 40, 9276, 4750, 5902, 7599, 7025, 9278, 8602, 7727, 3355, 2121, 7854, 6983, 299, 602, 7171, 9367, 4143, 1257, 7153, 2478, 5758, 3795, 1717, 5844, 2264, 8277, 3339, 912, 1151, 5313, 4717, 2293, 3511, 5717, 4735, 1889, 669, 2880, 7006, 4282, 6663, 2264, 9231, 6826, 7828, 3072, 2805, 6126, 396, 1512, 7453, 7960, 6125, 2219, 7228, 4262, 9134, 5303, 4699, 6441, 5645, 1072, 9369, 2861, 3181, 5211, 6821, 3504, 8006, 846, 4495, 3741, 2665, 8150, 5550, 8649, 597, 123, 8345, 7218, 7235, 4763, 1860, 5477, 6996, 8372, 8610, 3578, 2437, 2795, 2799, 2678, 5953, 5962, 312, 4158, 1340, 336, 3670, 6472, 139, 5152, 454, 5408, 4472, 6140, 7476, 6726, 8735, 649, 3226, 447, 3770, 910, 125, 1919, 3258, 3633, 4292, 7764, 681, 6492, 7468, 5932, 5071, 1463, 7096, 155, 8599, 6550, 2817, 1936, 4033, 9982, 6022, 9420, 3807, 9838, 6774, 390};
        for (int i : elements) {
            myHashSet.add(i);
        }
        int index = new Random().nextInt(elements.length);
        int element = elements[index];
        assertTrue(myHashSet.contains(element));
    }

    @Test
    public void removingANonPresentElementDoesNotThrow() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        int[] elements = new int[] {5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12};
        for (int i : elements) {
            myHashSet.add(i);
        }
        assertDoesNotThrow(()->{
            myHashSet.remove(1);
        });
    }

    @DisplayName("Removing an existing element returns true")
    @Test
    public void removingAnExistingElementReturnsTrue() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        int[] elements = new int[] {5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12};
        for (int i : elements) {
            myHashSet.add(i);
        }
        assertTrue(myHashSet.remove(17));
    }

    @DisplayName("Removing a non-existing element returns false")
    @Test
    public void removingANonExistingElementReturnsFalse() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        int[] elements = new int[] {5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12};
        for (int i : elements) {
            myHashSet.add(i);
        }
        assertFalse(myHashSet.remove(null));
    }

    @DisplayName("If we add then remove an element, running contains on that element returns false, even if it was a duplicate add.")
    @Test
    public void ifRemoveExistingElementThenContainsReturnsFalseDupe() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        int[] elements = new int[] {5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12};
        for (int i : elements) {
            myHashSet.add(i);
        }
        myHashSet.remove(88);
        assertFalse(myHashSet.contains(88));
    }

    @DisplayName("If we add and remove several elements, then isEmpty returns true.")
    @Test
    public void ifAddAndRemoveSeveralThenIsEmpty() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        int[] elements = new int[] {5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12};
        for (int i : elements) {
            myHashSet.add(i);
        }
        for (int elt : elements) {
            myHashSet.remove(elt);
        }
        assertTrue(myHashSet.isEmpty());
    }

    @DisplayName("Set can contain one instance of null.")
    @Test
    public void setCanContainOneInstanceOfNull() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        Integer[] elements = new Integer[] {5, 17, null, null};
        for (Integer i : elements) {
            myHashSet.add(i);
        }
        assertTrue(myHashSet.contains(null));
    }

    @DisplayName("After adding several elements, if we clear then isEmpty true.")
    @Test
    public void afterAddingSeveralElementsAndClearingIsEmpty() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        Integer[] elements = new Integer[] {5, 17, null, null, 5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12};
        for (Integer i : elements) {
            myHashSet.add(i);
        }
        myHashSet.clear();
        assertTrue(myHashSet.isEmpty());
    }

    @DisplayName("There is an addAll method for adding a collection")
    @Test
    public void canAddACollectionUsingAddAll() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        List<Integer> elements = new ArrayList<Integer>(Arrays.asList(5, 17, null, null, 5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12));
        myHashSet.addAll(elements);
        for (Integer i : elements) {
            assertTrue(myHashSet.contains(i));
        }
    }

    @DisplayName("There is a removeAll method for removing a collection")
    @Test
    public void canRemoveAllCollectionUsingRemoveAll() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        List<Integer> elements = new ArrayList<Integer>(Arrays.asList(5, 17, null, null, 5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12));
        myHashSet.addAll(elements);
        myHashSet.removeAll(elements);
        assertEquals(0, myHashSet.size());
    }

    @DisplayName("Running removeAll on non-existent elements does not throw.")
    @Test
    public void runningRemoveAllOnNonExistentElementsDoesNotThrow() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        List<Integer> elements = new ArrayList<Integer>(Arrays.asList(5, 17, null, null, 5, 17, 33, 134, 72, 88, 5, 17, 33, 9, 12));
        assertDoesNotThrow(()->{
            myHashSet.removeAll(elements);
        });
    }

    @DisplayName("Calling hasNext on set with element returns true")
    @Test
    public void iteratorHasNextReturnsTrueOnNonempty() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        List<Integer> elements = new ArrayList<Integer>(Arrays.asList(5));
        myHashSet.addAll(elements);
        Iterator<Integer> itr = myHashSet.iterator();
        assertTrue(itr.hasNext());
    }

    @DisplayName("Calling next on an empty set throws.")
    @Test
    public void callingNextOnEmptySetThrows() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        Iterator<Integer> itr = myHashSet.iterator();
        assertThrows(NoSuchElementException.class, itr::next);
    }

    @DisplayName("After all elements consumed, calling next again throws.")
    @Test
    public void callingNextOnConsumedIteratorThrows() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        List<Integer> elements = new ArrayList<Integer>(Arrays.asList(5, 6, 8));
        myHashSet.addAll(elements);
        Iterator<Integer> itr = myHashSet.iterator();
        while (itr.hasNext()) {
            itr.next();
        }
        assertThrows(NoSuchElementException.class, itr::next);
    }



    @DisplayName("Calling next counts correct number of elements")
    @Test
    public void iteratorCountsCorrectNumberOfElements() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        List<Integer> distinctElements = new ArrayList<Integer>(Arrays.asList(267, 164, 260, 291, 557, 610, 227, 274, 364, 792, 660, 541, 326, 484, 737, 936, 288, 446, 811, 59, 359, 390, 998, 958, 990, 955, 561, 1000, 226, 381, 800, 549, 992, 36, 659, 73, 751, 666, 456, 968, 526, 873, 272, 348, 56, 101, 254, 921, 98, 683, 223, 553, 474, 202, 862, 876, 214, 738, 868, 679, 767, 58, 204, 305, 818, 991, 540, 420, 323, 121, 959, 975, 713, 345, 374, 591, 115, 466, 966, 102, 794, 781, 899, 233, 770, 742, 698, 821, 96, 310, 289, 218, 613, 689, 1002, 611, 530, 134, 565, 170, 117, 176, 13, 298, 234, 595, 764, 795, 665, 492, 268, 142, 661, 232, 819, 328, 14, 138, 598, 253, 167, 504, 758, 879, 296, 545, 672, 636, 798, 841, 961, 801, 224, 49, 306, 548, 917, 779, 35, 95, 600, 407, 163, 478, 247, 148, 281, 179, 314, 307, 165, 888, 354, 850, 840, 411, 743, 37, 316, 63, 495, 385, 100, 27, 159, 48, 703, 719, 727, 582, 878, 704, 145, 568, 654, 750, 371, 285, 931, 521, 69, 378, 652, 491, 970, 946, 799, 208, 8, 71, 346, 822, 915, 392, 847, 418, 349, 655, 382, 768, 330, 696, 836, 940, 454, 358, 482, 363, 509, 192, 930, 453, 243, 438, 508, 741, 593, 650, 161, 271, 9, 309, 28, 372, 973, 724, 171, 872, 173, 322, 793, 413, 728, 266, 525, 755, 162, 676, 857, 651, 338, 45, 855, 718, 373, 77, 681, 506, 457, 421, 257, 365, 993, 151, 845, 410, 287, 140, 519, 551, 562, 809, 971, 927, 66, 710, 284, 91, 282, 960, 122, 772, 630, 442, 924, 278, 875, 628, 464, 433, 977, 503, 375, 871, 419, 319, 149, 788, 967, 705, 17, 201, 695, 623, 537, 680, 178, 668, 920, 547, 452, 203, 986, 773, 972, 70, 817, 715, 864, 105, 415, 337, 277, 22, 113, 182, 431, 716, 860, 263, 270, 714, 578, 387, 332, 573, 641, 633, 510, 782, 448, 892, 370, 943, 586, 356, 810, 603, 677, 827, 62, 813, 726, 366, 85, 902, 556, 929, 828, 976, 399, 68, 555, 861, 317, 731, 786, 193, 580, 605, 7, 785, 653, 700, 830, 687, 320, 383, 473, 152, 333, 467, 388, 92, 283, 869, 832, 47, 34, 945, 858, 104, 196, 487, 609, 126, 631, 197, 429, 670, 60, 111, 763, 172, 123, 426, 691, 563, 501, 80, 144, 55, 125, 74, 87, 350, 675, 686, 824, 443, 877, 797, 617, 746, 544, 587, 517, 94, 477, 231, 494, 851, 417, 12, 667, 884, 380, 757, 128, 980, 999, 671, 403, 688, 908, 185, 38, 108, 748, 951, 355, 52, 280, 498, 994, 702, 50, 606, 241, 823, 989, 353, 4, 244, 255, 32, 735, 776, 264, 759, 938, 514, 933, 536, 439, 987, 965, 132, 865, 405, 75, 86, 469, 969, 711, 327, 210, 745, 950, 471, 394, 460, 982, 634, 780, 601, 21, 859, 127, 46, 480, 906, 910, 583, 379, 901, 621, 546, 523, 137, 351, 762, 97, 61, 856, 303, 893, 814, 529, 574, 874, 198, 756, 33, 335, 483, 336, 622, 404, 997, 777, 312, 416, 885, 697, 259, 308, 64, 897, 883, 450, 424, 820, 10, 331, 462, 963, 760, 941, 535, 256, 599, 749, 842, 290, 658, 242, 648, 923, 774, 434, 16, 736, 802, 778, 83, 476, 391, 432, 248, 953, 76, 299, 300, 240, 614, 721, 302, 520, 114, 441, 733, 129, 42, 538, 237, 139, 585, 518, 570, 361, 207, 957, 422, 754, 414, 848, 343, 708, 220, 916, 251, 131, 286, 978, 662, 588, 766, 194, 838, 311, 486, 186, 709, 863, 690, 304, 531, 141, 445, 639, 40, 844, 497, 649, 985, 944, 607, 608, 867, 402, 673, 849, 181, 937, 195, 252, 209, 79, 576, 313, 808, 646, 430, 880, 488, 496, 425, 734, 644, 222, 739, 84, 20, 189, 928, 489, 334, 239, 475, 807, 107, 41, 803, 6, 118, 493, 925, 645, 806, 143, 78, 54, 816, 839, 352, 436, 318, 447, 771, 784, 707, 564, 932, 217, 964, 511, 656, 219, 376, 543, 894, 988, 895, 566, 386, 516, 852, 261, 918, 515, 909, 230, 805, 981, 136, 81, 571, 199, 377, 153, 408, 693, 175, 647, 82, 184, 744, 19, 183, 642, 618, 44, 505, 93, 24, 265, 626, 109, 926, 120, 325, 155, 180, 168, 674, 65, 761, 559, 150, 116, 831, 160, 124, 485, 340, 211, 1001, 428, 825, 455, 790, 67, 437, 911, 157, 444, 775, 360, 216, 522, 663, 398, 235, 948, 889, 293, 904, 712, 682, 706, 499, 368, 212, 53, 26, 717, 468, 550, 135, 133, 886, 829, 560, 258, 90, 465, 463, 177, 221, 470, 854, 694, 581, 329, 597, 238, 922, 25, 479, 459, 643, 669, 451, 31, 51, 635, 720, 513, 913, 569, 996, 347, 891, 276, 783, 449, 596, 558, 935, 406, 400, 225, 396, 664, 954, 11, 590, 57, 787, 602, 843, 789, 5, 552, 297, 534, 250, 572, 979, 472, 215, 723, 834, 344, 395, 401, 292, 729, 147, 99, 507, 765, 174, 579, 835, 620, 339, 458, 490, 995, 246, 423, 919, 397, 812, 791, 213, 528, 321, 191, 294));
        myHashSet.addAll(distinctElements);
        Iterator<Integer> itr = myHashSet.iterator();
        int count = 0;
        while (itr.hasNext()) {
            itr.next();
            count++;
        }
        assertEquals(distinctElements.size(), count);
    }

    @DisplayName("Iterator iterates over correct elements")
    @Test
    public void iteratorIteratesOverCorrectElements() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        List<Integer> elements = new ArrayList<Integer>(Arrays.asList(5, 6, 8));
        myHashSet.addAll(elements);
        Iterator<Integer> itr = myHashSet.iterator();
        List<Integer> output = new ArrayList<>();
        while (itr.hasNext()) {
            output.add(itr.next());
        }
        assertEquals(3, output.size());
        assertTrue(output.contains(5));
        assertTrue(output.contains(6));
        assertTrue(output.contains(8));
    }

    @DisplayName("Iterator remove removes correct elt")
    @Test
    public void iteratorRemoveRemovesCorrectElt() {
        for (int i = 0; i < 50; i++) {
            MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
            List<Integer> elements = new ArrayList<Integer>(Arrays.asList(116, 12, 143, 57, 161, 48, 45, 65, 3, 27, 60, 138, 77, 37, 58, 110, 81, 44, 130, 169, 177, 10, 21, 89, 75, 117, 192, 170, 147, 43, 36, 196, 93, 98, 10, 77, 182, 86, 188, 42, 63, 140, 197, 52, 79, 98, 124, 143, 18, 172));
            myHashSet.addAll(elements);
            Iterator<Integer> itr = myHashSet.iterator();
            int randomIndex = new Random().nextInt(elements.size());
            int randomElement = elements.get(randomIndex);

            while (itr.hasNext()) {
                Integer last = itr.next();
                if (last == randomElement) {
                    itr.remove();
                }
            }
            assertFalse(myHashSet.contains(randomElement));
        }
    }

    @DisplayName("forEachRemaining applies.")
    @Test
    public void forEachRemainingApplies() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        List<Integer> elements = new ArrayList<Integer>(Arrays.asList(5, 6, 8, 9, 10, 11, 14, 16, 18, 22));
        myHashSet.addAll(elements);
        Iterator<Integer> itr = myHashSet.iterator();
        List<Integer> output1 = new ArrayList<>();
        List<Integer> output2 = new ArrayList<>();
        int count = 0;
        int maxCount = 3;
        while (itr.hasNext() && count < maxCount) {
            output1.add(itr.next());
            count++;
        }
        itr.forEachRemaining(output2::add);
        for (Integer i : output1) {
            assertTrue(myHashSet.contains(i));
        }
        for (Integer i : output2) {
            assertTrue(myHashSet.contains(i));
        }
        assertEquals(myHashSet.size(), output1.size() + output2.size());
    }

    @DisplayName("retainAll works")
    @Test
    public void retainAllWorks() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(55);
        List<Integer> elements = new ArrayList<Integer>(Arrays.asList(3, 5, 6, 8));
        List<Integer> toRetain = new ArrayList<Integer>(Arrays.asList(5, 6, 15));
        myHashSet.addAll(elements);
        myHashSet.retainAll(toRetain);
        assertEquals(2, myHashSet.size());
        assertTrue(myHashSet.contains(5));
        assertTrue(myHashSet.contains(6));
    }
}
