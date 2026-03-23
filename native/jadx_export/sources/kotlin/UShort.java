package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* compiled from: UShort.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\u0017\u0010\rJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0018\u0010\u000fJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0019\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\u001d\u0010\rJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001e\u0010\u000fJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u001f\u0010\u0012J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b \u0010\u001bJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\"\u0010\rJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b#\u0010\u000fJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b$\u0010\u0012J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b%\u0010\u001bJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b'\u0010\rJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b(\u0010\u000fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b)\u0010\u0012J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b*\u0010\u001bJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b,\u0010\rJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b-\u0010\u000fJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b.\u0010\u0012J\u0018\u0010+\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b/\u0010\u001bJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b1\u0010\rJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b2\u0010\u000fJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b3\u0010\u0012J\u0018\u00100\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b4\u0010\u001bJ\u0018\u00105\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b6\u00107J\u0018\u00105\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b8\u00109J\u0018\u00105\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b:\u0010\u0012J\u0018\u00105\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b;\u0010\u001bJ\u0010\u0010<\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b=\u0010\u0005J\u0010\u0010>\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b?\u0010\u0005J\u0018\u0010@\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bB\u0010CJ\u0018\u0010D\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010CJ\u0018\u0010F\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bG\u00109J\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bI\u00109J\u0018\u0010J\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bK\u00109J\u0010\u0010L\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bM\u0010\u0005J\u0010\u0010N\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020\tH\u0087\b¢\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001a\u00020XH\u0087\b¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b\\\u0010QJ\u0010\u0010]\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b^\u0010\u0005J\u0010\u0010_\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b`\u0010VJ\u0010\u0010a\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\bb\u0010ZJ\u0010\u0010c\u001a\u00020dH\u0087\b¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\u0087\b¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0013\u0010o\u001a\u00020p2\b\u0010\n\u001a\u0004\u0018\u00010qHÖ\u0003J\t\u0010r\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006t"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "compareTo", "", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "compareTo-xj2QHRw", "(SS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(SJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(SB)B", "mod-xj2QHRw", "(SS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-Mh2AYeg", "dec", "dec-Mh2AYeg", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "and", "and-xj2QHRw", "or", "or-xj2QHRw", "xor", "xor-xj2QHRw", "inv", "inv-Mh2AYeg", "toByte", "", "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(S)F", "toDouble", "", "toDouble-impl", "(S)D", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class UShort implements Comparable<UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShort m7274boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m7280constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7286equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7287equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7292hashCodeimpl(short s) {
        return s;
    }

    public boolean equals(Object other) {
        return m7286equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m7292hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(getData() & MAX_VALUE, uShort.getData() & MAX_VALUE);
    }

    private /* synthetic */ UShort(short data) {
        this.data = data;
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m7275compareTo7apg3OU(short arg0, byte other) {
        return Intrinsics.compare(65535 & arg0, other & UByte.MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m7278compareToxj2QHRw(short other) {
        return Intrinsics.compare(getData() & MAX_VALUE, 65535 & other);
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m7279compareToxj2QHRw(short arg0, short other) {
        return Intrinsics.compare(arg0 & MAX_VALUE, 65535 & other);
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m7277compareToWZ4Q5Ns(short arg0, int other) {
        return Integer.compare(UInt.m7094constructorimpl(65535 & arg0) ^ Integer.MIN_VALUE, other ^ Integer.MIN_VALUE);
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m7276compareToVKZWuLQ(short arg0, long other) {
        return Long.compare(ULong.m7173constructorimpl(arg0 & 65535) ^ Long.MIN_VALUE, other ^ Long.MIN_VALUE);
    }

    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m7304plus7apg3OU(short arg0, byte other) {
        return UInt.m7094constructorimpl(UInt.m7094constructorimpl(65535 & arg0) + UInt.m7094constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m7307plusxj2QHRw(short arg0, short other) {
        return UInt.m7094constructorimpl(UInt.m7094constructorimpl(arg0 & MAX_VALUE) + UInt.m7094constructorimpl(65535 & other));
    }

    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m7306plusWZ4Q5Ns(short arg0, int other) {
        return UInt.m7094constructorimpl(UInt.m7094constructorimpl(65535 & arg0) + other);
    }

    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m7305plusVKZWuLQ(short arg0, long other) {
        return ULong.m7173constructorimpl(ULong.m7173constructorimpl(arg0 & 65535) + other);
    }

    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m7295minus7apg3OU(short arg0, byte other) {
        return UInt.m7094constructorimpl(UInt.m7094constructorimpl(65535 & arg0) - UInt.m7094constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m7298minusxj2QHRw(short arg0, short other) {
        return UInt.m7094constructorimpl(UInt.m7094constructorimpl(arg0 & MAX_VALUE) - UInt.m7094constructorimpl(65535 & other));
    }

    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m7297minusWZ4Q5Ns(short arg0, int other) {
        return UInt.m7094constructorimpl(UInt.m7094constructorimpl(65535 & arg0) - other);
    }

    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m7296minusVKZWuLQ(short arg0, long other) {
        return ULong.m7173constructorimpl(ULong.m7173constructorimpl(arg0 & 65535) - other);
    }

    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m7314times7apg3OU(short arg0, byte other) {
        return UInt.m7094constructorimpl(UInt.m7094constructorimpl(65535 & arg0) * UInt.m7094constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m7317timesxj2QHRw(short arg0, short other) {
        return UInt.m7094constructorimpl(UInt.m7094constructorimpl(arg0 & MAX_VALUE) * UInt.m7094constructorimpl(65535 & other));
    }

    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m7316timesWZ4Q5Ns(short arg0, int other) {
        return UInt.m7094constructorimpl(UInt.m7094constructorimpl(65535 & arg0) * other);
    }

    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m7315timesVKZWuLQ(short arg0, long other) {
        return ULong.m7173constructorimpl(ULong.m7173constructorimpl(arg0 & 65535) * other);
    }

    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m7282div7apg3OU(short arg0, byte other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7094constructorimpl(65535 & arg0), UInt.m7094constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m7285divxj2QHRw(short arg0, short other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7094constructorimpl(arg0 & MAX_VALUE), UInt.m7094constructorimpl(65535 & other));
    }

    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m7284divWZ4Q5Ns(short arg0, int other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7094constructorimpl(65535 & arg0), other);
    }

    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m7283divVKZWuLQ(short arg0, long other) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m7173constructorimpl(arg0 & 65535), other);
    }

    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m7310rem7apg3OU(short arg0, byte other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m7094constructorimpl(65535 & arg0), UInt.m7094constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m7313remxj2QHRw(short arg0, short other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m7094constructorimpl(arg0 & MAX_VALUE), UInt.m7094constructorimpl(65535 & other));
    }

    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m7312remWZ4Q5Ns(short arg0, int other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m7094constructorimpl(65535 & arg0), other);
    }

    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m7311remVKZWuLQ(short arg0, long other) {
        return UByte$$ExternalSyntheticBackport2.m(ULong.m7173constructorimpl(arg0 & 65535), other);
    }

    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m7288floorDiv7apg3OU(short arg0, byte other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7094constructorimpl(65535 & arg0), UInt.m7094constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m7291floorDivxj2QHRw(short arg0, short other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7094constructorimpl(arg0 & MAX_VALUE), UInt.m7094constructorimpl(65535 & other));
    }

    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m7290floorDivWZ4Q5Ns(short arg0, int other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7094constructorimpl(65535 & arg0), other);
    }

    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m7289floorDivVKZWuLQ(short arg0, long other) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m7173constructorimpl(arg0 & 65535), other);
    }

    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m7299mod7apg3OU(short arg0, byte other) {
        return UByte.m7017constructorimpl((byte) UByte$$ExternalSyntheticBackport1.m(UInt.m7094constructorimpl(65535 & arg0), UInt.m7094constructorimpl(other & UByte.MAX_VALUE)));
    }

    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m7302modxj2QHRw(short arg0, short other) {
        return m7280constructorimpl((short) UByte$$ExternalSyntheticBackport1.m(UInt.m7094constructorimpl(arg0 & MAX_VALUE), UInt.m7094constructorimpl(65535 & other)));
    }

    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m7301modWZ4Q5Ns(short arg0, int other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m7094constructorimpl(65535 & arg0), other);
    }

    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m7300modVKZWuLQ(short arg0, long other) {
        return UByte$$ExternalSyntheticBackport2.m(ULong.m7173constructorimpl(arg0 & 65535), other);
    }

    /* renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m7293incMh2AYeg(short arg0) {
        return m7280constructorimpl((short) (arg0 + 1));
    }

    /* renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m7281decMh2AYeg(short arg0) {
        return m7280constructorimpl((short) (arg0 - 1));
    }

    /* renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final UIntRange m7308rangeToxj2QHRw(short arg0, short other) {
        return new UIntRange(UInt.m7094constructorimpl(arg0 & MAX_VALUE), UInt.m7094constructorimpl(65535 & other), null);
    }

    /* renamed from: rangeUntil-xj2QHRw, reason: not valid java name */
    private static final UIntRange m7309rangeUntilxj2QHRw(short arg0, short other) {
        return URangesKt.m8272untilJ1ME1BU(UInt.m7094constructorimpl(arg0 & MAX_VALUE), UInt.m7094constructorimpl(65535 & other));
    }

    /* renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m7273andxj2QHRw(short arg0, short other) {
        return m7280constructorimpl((short) (arg0 & other));
    }

    /* renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m7303orxj2QHRw(short arg0, short other) {
        return m7280constructorimpl((short) (arg0 | other));
    }

    /* renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m7329xorxj2QHRw(short arg0, short other) {
        return m7280constructorimpl((short) (arg0 ^ other));
    }

    /* renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m7294invMh2AYeg(short arg0) {
        return m7280constructorimpl((short) (~arg0));
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m7318toByteimpl(short arg0) {
        return (byte) arg0;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m7323toShortimpl(short arg0) {
        return arg0;
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m7321toIntimpl(short arg0) {
        return 65535 & arg0;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m7322toLongimpl(short arg0) {
        return arg0 & 65535;
    }

    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m7325toUBytew2LRezQ(short arg0) {
        return UByte.m7017constructorimpl((byte) arg0);
    }

    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m7328toUShortMh2AYeg(short arg0) {
        return arg0;
    }

    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m7326toUIntpVg5ArA(short arg0) {
        return UInt.m7094constructorimpl(65535 & arg0);
    }

    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m7327toULongsVKNKU(short arg0) {
        return ULong.m7173constructorimpl(arg0 & 65535);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m7320toFloatimpl(short arg0) {
        return (float) UnsignedKt.uintToDouble(65535 & arg0);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m7319toDoubleimpl(short arg0) {
        return UnsignedKt.uintToDouble(65535 & arg0);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7324toStringimpl(short arg0) {
        return String.valueOf(65535 & arg0);
    }

    public String toString() {
        return m7324toStringimpl(this.data);
    }
}
