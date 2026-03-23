package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _UComparisons.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a(\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a\u001f\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b'\u0010\b\u001a\u001f\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b(\u0010\u000b\u001a\u001f\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b)\u0010\u000e\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a(\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b+\u0010\u0013\u001a(\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b,\u0010\u0015\u001a(\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b-\u0010\u0017\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b.\u0010\u001b\u001a#\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b/\u0010\u001e\u001a#\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lkotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lkotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "c", "maxOf-WZ9TVnA", "(III)I", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", "other", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-J1ME1BU", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes5.dex */
public class UComparisonsKt___UComparisonsKt {
    /* renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static final int m8185maxOfJ1ME1BU(int a, int b) {
        return Integer.compare(a ^ Integer.MIN_VALUE, b ^ Integer.MIN_VALUE) >= 0 ? a : b;
    }

    /* renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static final long m8193maxOfeb3DHEI(long a, long b) {
        return Long.compare(a ^ Long.MIN_VALUE, b ^ Long.MIN_VALUE) >= 0 ? a : b;
    }

    /* renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m8186maxOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare(a & UByte.MAX_VALUE, b & UByte.MAX_VALUE) >= 0 ? a : b;
    }

    /* renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m8184maxOf5PvTz6A(short a, short b) {
        return Intrinsics.compare(a & UShort.MAX_VALUE, 65535 & b) >= 0 ? a : b;
    }

    /* renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m8190maxOfWZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.m8185maxOfJ1ME1BU(a, UComparisonsKt.m8185maxOfJ1ME1BU(b, c));
    }

    /* renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m8194maxOfsambcqE(long a, long b, long c) {
        return UComparisonsKt.m8193maxOfeb3DHEI(a, UComparisonsKt.m8193maxOfeb3DHEI(b, c));
    }

    /* renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m8192maxOfb33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.m8186maxOfKr8caGY(a, UComparisonsKt.m8186maxOfKr8caGY(b, c));
    }

    /* renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m8189maxOfVKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.m8184maxOf5PvTz6A(a, UComparisonsKt.m8184maxOf5PvTz6A(b, c));
    }

    /* renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m8187maxOfMd2H83M(int a, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int max = a;
        int iM7155getSizeimpl = UIntArray.m7155getSizeimpl(other);
        for (int i = 0; i < iM7155getSizeimpl; i++) {
            int e = UIntArray.m7154getpVg5ArA(other, i);
            max = UComparisonsKt.m8185maxOfJ1ME1BU(max, e);
        }
        return max;
    }

    /* renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m8188maxOfR03FKyM(long a, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long max = a;
        int iM7234getSizeimpl = ULongArray.m7234getSizeimpl(other);
        for (int i = 0; i < iM7234getSizeimpl; i++) {
            long e = ULongArray.m7233getsVKNKU(other, i);
            max = UComparisonsKt.m8193maxOfeb3DHEI(max, e);
        }
        return max;
    }

    /* renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m8191maxOfWr6uiD8(byte a, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte max = a;
        int iM7076getSizeimpl = UByteArray.m7076getSizeimpl(other);
        for (int i = 0; i < iM7076getSizeimpl; i++) {
            byte e = UByteArray.m7075getw2LRezQ(other, i);
            max = UComparisonsKt.m8186maxOfKr8caGY(max, e);
        }
        return max;
    }

    /* renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m8195maxOft1qELG4(short a, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short max = a;
        int iM7339getSizeimpl = UShortArray.m7339getSizeimpl(other);
        for (int i = 0; i < iM7339getSizeimpl; i++) {
            short e = UShortArray.m7338getMh2AYeg(other, i);
            max = UComparisonsKt.m8184maxOf5PvTz6A(max, e);
        }
        return max;
    }

    /* renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static final int m8197minOfJ1ME1BU(int a, int b) {
        return Integer.compare(a ^ Integer.MIN_VALUE, b ^ Integer.MIN_VALUE) <= 0 ? a : b;
    }

    /* renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static final long m8205minOfeb3DHEI(long a, long b) {
        return Long.compare(a ^ Long.MIN_VALUE, b ^ Long.MIN_VALUE) <= 0 ? a : b;
    }

    /* renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m8198minOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare(a & UByte.MAX_VALUE, b & UByte.MAX_VALUE) <= 0 ? a : b;
    }

    /* renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m8196minOf5PvTz6A(short a, short b) {
        return Intrinsics.compare(a & UShort.MAX_VALUE, 65535 & b) <= 0 ? a : b;
    }

    /* renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m8202minOfWZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.m8197minOfJ1ME1BU(a, UComparisonsKt.m8197minOfJ1ME1BU(b, c));
    }

    /* renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m8206minOfsambcqE(long a, long b, long c) {
        return UComparisonsKt.m8205minOfeb3DHEI(a, UComparisonsKt.m8205minOfeb3DHEI(b, c));
    }

    /* renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m8204minOfb33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.m8198minOfKr8caGY(a, UComparisonsKt.m8198minOfKr8caGY(b, c));
    }

    /* renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m8201minOfVKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.m8196minOf5PvTz6A(a, UComparisonsKt.m8196minOf5PvTz6A(b, c));
    }

    /* renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m8199minOfMd2H83M(int a, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int min = a;
        int iM7155getSizeimpl = UIntArray.m7155getSizeimpl(other);
        for (int i = 0; i < iM7155getSizeimpl; i++) {
            int e = UIntArray.m7154getpVg5ArA(other, i);
            min = UComparisonsKt.m8197minOfJ1ME1BU(min, e);
        }
        return min;
    }

    /* renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m8200minOfR03FKyM(long a, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long min = a;
        int iM7234getSizeimpl = ULongArray.m7234getSizeimpl(other);
        for (int i = 0; i < iM7234getSizeimpl; i++) {
            long e = ULongArray.m7233getsVKNKU(other, i);
            min = UComparisonsKt.m8205minOfeb3DHEI(min, e);
        }
        return min;
    }

    /* renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m8203minOfWr6uiD8(byte a, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte min = a;
        int iM7076getSizeimpl = UByteArray.m7076getSizeimpl(other);
        for (int i = 0; i < iM7076getSizeimpl; i++) {
            byte e = UByteArray.m7075getw2LRezQ(other, i);
            min = UComparisonsKt.m8198minOfKr8caGY(min, e);
        }
        return min;
    }

    /* renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m8207minOft1qELG4(short a, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short min = a;
        int iM7339getSizeimpl = UShortArray.m7339getSizeimpl(other);
        for (int i = 0; i < iM7339getSizeimpl; i++) {
            short e = UShortArray.m7338getMh2AYeg(other, i);
            min = UComparisonsKt.m8196minOf5PvTz6A(min, e);
        }
        return min;
    }
}
