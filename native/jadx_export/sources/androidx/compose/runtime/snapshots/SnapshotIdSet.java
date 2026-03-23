package androidx.compose.runtime.snapshots;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* compiled from: SnapshotIdSet.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J:\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002'\u0010\u0011\u001a#\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0012H\u0086\bJ\u001d\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0096\u0002J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "acc", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    private SnapshotIdSet(long upperSet, long lowerSet, int lowerBound, int[] belowBound) {
        this.upperSet = upperSet;
        this.lowerSet = lowerSet;
        this.lowerBound = lowerBound;
        this.belowBound = belowBound;
    }

    public final boolean get(int bit) {
        int[] it;
        int offset = bit - this.lowerBound;
        if (offset >= 0 && offset < 64) {
            return ((1 << offset) & this.lowerSet) != 0;
        }
        if (offset >= 64 && offset < 128) {
            return ((1 << (offset + (-64))) & this.upperSet) != 0;
        }
        if (offset <= 0 && (it = this.belowBound) != null) {
            return SnapshotIdSetKt.binarySearch(it, bit) >= 0;
        }
        return false;
    }

    public final SnapshotIdSet set(int bit) {
        int newLowerBound;
        long newLowerSet;
        int[] intArray;
        long j;
        long j2;
        int offset = bit - this.lowerBound;
        long j3 = 1;
        long j4 = 0;
        if (offset >= 0 && offset < 64) {
            long mask = 1 << offset;
            if ((this.lowerSet & mask) == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet | mask, this.lowerBound, this.belowBound);
            }
        } else if (offset >= 64 && offset < 128) {
            long mask2 = 1 << (offset - 64);
            if ((this.upperSet & mask2) == 0) {
                return new SnapshotIdSet(this.upperSet | mask2, this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (offset >= 128) {
            if (!get(bit)) {
                long newUpperSet = this.upperSet;
                long newLowerSet2 = this.lowerSet;
                int newLowerBound2 = this.lowerBound;
                List list = null;
                int targetLowerBound = ((bit + 1) / 64) * 64;
                long newUpperSet2 = newUpperSet;
                while (true) {
                    if (newLowerBound2 >= targetLowerBound) {
                        newLowerBound = newLowerBound2;
                        newLowerSet = newLowerSet2;
                        break;
                    }
                    if (newLowerSet2 == j4) {
                        j = j3;
                        j2 = j4;
                    } else {
                        if (list != null) {
                            j = j3;
                            j2 = j4;
                        } else {
                            List $this$set_u24lambda_u243 = new ArrayList();
                            j = j3;
                            int[] it = this.belowBound;
                            if (it == null) {
                                j2 = j4;
                            } else {
                                j2 = j4;
                                for (int element$iv : it) {
                                    $this$set_u24lambda_u243.add(Integer.valueOf(element$iv));
                                }
                            }
                            list = $this$set_u24lambda_u243;
                        }
                        for (int i = 0; i < 64; i++) {
                            int bitOffset = i;
                            if (((j << bitOffset) & newLowerSet2) != j2) {
                                list.add(Integer.valueOf(bitOffset + newLowerBound2));
                            }
                        }
                    }
                    if (newUpperSet2 == j2) {
                        newLowerBound = targetLowerBound;
                        newLowerSet = 0;
                        break;
                    }
                    newLowerSet2 = newUpperSet2;
                    newUpperSet2 = 0;
                    newLowerBound2 += 64;
                    j3 = j;
                    j4 = j2;
                }
                if (list == null || (intArray = CollectionsKt.toIntArray(list)) == null) {
                    intArray = this.belowBound;
                }
                return new SnapshotIdSet(newUpperSet2, newLowerSet, newLowerBound, intArray).set(bit);
            }
        } else {
            int[] array = this.belowBound;
            if (array == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, new int[]{bit});
            }
            int location = SnapshotIdSetKt.binarySearch(array, bit);
            if (location < 0) {
                int insertLocation = -(location + 1);
                int newSize = array.length + 1;
                int[] newBelowBound = new int[newSize];
                ArraysKt.copyInto(array, newBelowBound, 0, 0, insertLocation);
                ArraysKt.copyInto(array, newBelowBound, insertLocation + 1, insertLocation, newSize - 1);
                newBelowBound[insertLocation] = bit;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, newBelowBound);
            }
        }
        return this;
    }

    public final SnapshotIdSet clear(int bit) {
        int[] array;
        int location;
        int offset = bit - this.lowerBound;
        if (offset >= 0 && offset < 64) {
            long mask = 1 << offset;
            if ((this.lowerSet & mask) != 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet & (~mask), this.lowerBound, this.belowBound);
            }
        } else if (offset >= 64 && offset < 128) {
            long mask2 = 1 << (offset - 64);
            if ((this.upperSet & mask2) != 0) {
                return new SnapshotIdSet(this.upperSet & (~mask2), this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (offset < 0 && (array = this.belowBound) != null && (location = SnapshotIdSetKt.binarySearch(array, bit)) >= 0) {
            int newSize = array.length - 1;
            if (newSize == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
            }
            int[] newBelowBound = new int[newSize];
            if (location > 0) {
                ArraysKt.copyInto(array, newBelowBound, 0, 0, location);
            }
            if (location < newSize) {
                ArraysKt.copyInto(array, newBelowBound, location, location + 1, newSize + 1);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, newBelowBound);
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet bits) {
        long j;
        long j2;
        if (bits == EMPTY) {
            return this;
        }
        if (this == EMPTY) {
            return EMPTY;
        }
        if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
            return new SnapshotIdSet((~bits.upperSet) & this.upperSet, (~bits.lowerSet) & this.lowerSet, this.lowerBound, this.belowBound);
        }
        Object accumulator$iv = this;
        int[] belowBound$iv$iv = bits.belowBound;
        if (belowBound$iv$iv != null) {
            for (int element$iv$iv : belowBound$iv$iv) {
                SnapshotIdSet previous = (SnapshotIdSet) accumulator$iv;
                accumulator$iv = previous.clear(element$iv$iv);
            }
        }
        long j3 = 1;
        if (bits.lowerSet != 0) {
            int index$iv$iv = 0;
            while (index$iv$iv < 64) {
                if ((bits.lowerSet & (j3 << index$iv$iv)) != 0) {
                    int element$iv = bits.lowerBound + index$iv$iv;
                    j2 = j3;
                    SnapshotIdSet previous2 = (SnapshotIdSet) accumulator$iv;
                    accumulator$iv = previous2.clear(element$iv);
                } else {
                    j2 = j3;
                }
                index$iv$iv++;
                j3 = j2;
            }
            j = j3;
        } else {
            j = 1;
        }
        if (bits.upperSet != 0) {
            for (int index$iv$iv2 = 0; index$iv$iv2 < 64; index$iv$iv2++) {
                if ((bits.upperSet & (j << index$iv$iv2)) != 0) {
                    int element$iv2 = index$iv$iv2 + 64 + bits.lowerBound;
                    SnapshotIdSet previous3 = (SnapshotIdSet) accumulator$iv;
                    accumulator$iv = previous3.clear(element$iv2);
                }
            }
        }
        Object this_$iv$iv = accumulator$iv;
        return (SnapshotIdSet) this_$iv$iv;
    }

    public final SnapshotIdSet and(SnapshotIdSet bits) {
        long j;
        long j2;
        long j3;
        if (!Intrinsics.areEqual(bits, EMPTY) && !Intrinsics.areEqual(this, EMPTY)) {
            long j4 = 0;
            if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
                long newUpper = this.upperSet & bits.upperSet;
                long newLower = this.lowerSet & bits.lowerSet;
                if (newUpper == 0 && newLower == 0 && this.belowBound == null) {
                    return EMPTY;
                }
                return new SnapshotIdSet(bits.upperSet & this.upperSet, bits.lowerSet & this.lowerSet, this.lowerBound, this.belowBound);
            }
            int i = 0;
            long j5 = 1;
            if (this.belowBound != null) {
                SnapshotIdSet initial$iv = EMPTY;
                SnapshotIdSet this_$iv = initial$iv;
                int[] belowBound$iv$iv = bits.belowBound;
                if (belowBound$iv$iv != null) {
                    int length = belowBound$iv$iv.length;
                    while (i < length) {
                        int element$iv$iv = belowBound$iv$iv[i];
                        SnapshotIdSet previous = this_$iv;
                        if (get(element$iv$iv)) {
                            previous = previous.set(element$iv$iv);
                        }
                        this_$iv = previous;
                        i++;
                    }
                }
                if (bits.lowerSet != 0) {
                    for (int index$iv$iv = 0; index$iv$iv < 64; index$iv$iv++) {
                        if ((bits.lowerSet & (1 << index$iv$iv)) != 0) {
                            int element$iv = bits.lowerBound + index$iv$iv;
                            SnapshotIdSet previous2 = this_$iv;
                            if (get(element$iv)) {
                                previous2 = previous2.set(element$iv);
                            }
                            this_$iv = previous2;
                        }
                    }
                }
                if (bits.upperSet != 0) {
                    for (int index$iv$iv2 = 0; index$iv$iv2 < 64; index$iv$iv2++) {
                        if ((bits.upperSet & (1 << index$iv$iv2)) != 0) {
                            int element$iv2 = index$iv$iv2 + 64 + bits.lowerBound;
                            SnapshotIdSet previous3 = this_$iv;
                            if (get(element$iv2)) {
                                previous3 = previous3.set(element$iv2);
                            }
                            this_$iv = previous3;
                        }
                    }
                }
                return this_$iv;
            }
            SnapshotIdSet initial$iv2 = EMPTY;
            SnapshotIdSet this_$iv2 = initial$iv2;
            int[] belowBound$iv$iv2 = this.belowBound;
            if (belowBound$iv$iv2 != null) {
                int length2 = belowBound$iv$iv2.length;
                while (i < length2) {
                    int element$iv$iv2 = belowBound$iv$iv2[i];
                    SnapshotIdSet previous4 = this_$iv2;
                    long j6 = j4;
                    if (bits.get(element$iv$iv2)) {
                        previous4 = previous4.set(element$iv$iv2);
                    }
                    this_$iv2 = previous4;
                    i++;
                    j4 = j6;
                }
                j = j4;
            } else {
                j = 0;
            }
            if (this.lowerSet != j) {
                int index$iv$iv3 = 0;
                while (index$iv$iv3 < 64) {
                    if ((this.lowerSet & (j5 << index$iv$iv3)) != j) {
                        int element$iv3 = this.lowerBound + index$iv$iv3;
                        SnapshotIdSet previous5 = this_$iv2;
                        j3 = j5;
                        if (bits.get(element$iv3)) {
                            previous5 = previous5.set(element$iv3);
                        }
                        this_$iv2 = previous5;
                    } else {
                        j3 = j5;
                    }
                    index$iv$iv3++;
                    j5 = j3;
                }
                j2 = j5;
            } else {
                j2 = 1;
            }
            if (this.upperSet == j) {
                return this_$iv2;
            }
            for (int index$iv$iv4 = 0; index$iv$iv4 < 64; index$iv$iv4++) {
                if ((this.upperSet & (j2 << index$iv$iv4)) != j) {
                    int element$iv4 = index$iv$iv4 + 64 + this.lowerBound;
                    SnapshotIdSet previous6 = this_$iv2;
                    if (bits.get(element$iv4)) {
                        previous6 = previous6.set(element$iv4);
                    }
                    this_$iv2 = previous6;
                }
            }
            return this_$iv2;
        }
        return EMPTY;
    }

    public final SnapshotIdSet or(SnapshotIdSet bits) {
        long j;
        long j2;
        if (bits == EMPTY) {
            return this;
        }
        if (this == EMPTY) {
            return bits;
        }
        if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
            return new SnapshotIdSet(bits.upperSet | this.upperSet, bits.lowerSet | this.lowerSet, this.lowerBound, this.belowBound);
        }
        int i = 0;
        long j3 = 0;
        if (this.belowBound == null) {
            SnapshotIdSet snapshotIdSet = bits;
            int[] belowBound$iv$iv = this.belowBound;
            if (belowBound$iv$iv != null) {
                int length = belowBound$iv$iv.length;
                while (i < length) {
                    int element$iv$iv = belowBound$iv$iv[i];
                    SnapshotIdSet previous = snapshotIdSet;
                    snapshotIdSet = previous.set(element$iv$iv);
                    i++;
                }
                j2 = 1;
            } else {
                j2 = 1;
            }
            if (this.lowerSet != 0) {
                for (int index$iv$iv = 0; index$iv$iv < 64; index$iv$iv++) {
                    if ((this.lowerSet & (j2 << index$iv$iv)) != 0) {
                        int element$iv = this.lowerBound + index$iv$iv;
                        SnapshotIdSet previous2 = snapshotIdSet;
                        snapshotIdSet = previous2.set(element$iv);
                    }
                }
            }
            if (this.upperSet == 0) {
                return snapshotIdSet;
            }
            for (int index$iv$iv2 = 0; index$iv$iv2 < 64; index$iv$iv2++) {
                if ((this.upperSet & (j2 << index$iv$iv2)) != 0) {
                    int element$iv2 = index$iv$iv2 + 64 + this.lowerBound;
                    SnapshotIdSet previous3 = snapshotIdSet;
                    snapshotIdSet = previous3.set(element$iv2);
                }
            }
            return snapshotIdSet;
        }
        Object accumulator$iv = this;
        int[] belowBound$iv$iv2 = bits.belowBound;
        if (belowBound$iv$iv2 != null) {
            int length2 = belowBound$iv$iv2.length;
            while (i < length2) {
                int element$iv$iv2 = belowBound$iv$iv2[i];
                long j4 = j3;
                SnapshotIdSet previous4 = (SnapshotIdSet) accumulator$iv;
                accumulator$iv = previous4.set(element$iv$iv2);
                i++;
                j3 = j4;
            }
            j = j3;
        } else {
            j = 0;
        }
        if (bits.lowerSet != j) {
            for (int index$iv$iv3 = 0; index$iv$iv3 < 64; index$iv$iv3++) {
                if ((bits.lowerSet & (1 << index$iv$iv3)) != j) {
                    int element$iv3 = bits.lowerBound + index$iv$iv3;
                    SnapshotIdSet previous5 = (SnapshotIdSet) accumulator$iv;
                    accumulator$iv = previous5.set(element$iv3);
                }
            }
        }
        if (bits.upperSet != j) {
            for (int index$iv$iv4 = 0; index$iv$iv4 < 64; index$iv$iv4++) {
                if ((bits.upperSet & (1 << index$iv$iv4)) != j) {
                    int element$iv4 = index$iv$iv4 + 64 + bits.lowerBound;
                    SnapshotIdSet previous6 = (SnapshotIdSet) accumulator$iv;
                    accumulator$iv = previous6.set(element$iv4);
                }
            }
        }
        return (SnapshotIdSet) accumulator$iv;
    }

    /* compiled from: SnapshotIdSet.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {295, AnimationConstants.DefaultDurationMillis, 307}, m = "invokeSuspend", n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
    /* renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = SnapshotIdSet.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00dd  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0085 -> B:16:0x0088). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00aa -> B:29:0x00cb). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c7 -> B:29:0x00cb). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00e8 -> B:41:0x010b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0107 -> B:41:0x010b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 284
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new AnonymousClass1(null)).iterator();
    }

    public final SnapshotIdSet fastFold(SnapshotIdSet initial, Function2<? super SnapshotIdSet, ? super Integer, SnapshotIdSet> operation) {
        Object accumulator = initial;
        int[] belowBound$iv = this.belowBound;
        if (belowBound$iv != null) {
            for (int element$iv : belowBound$iv) {
                accumulator = operation.invoke(accumulator, Integer.valueOf(element$iv));
            }
        }
        if (this.lowerSet != 0) {
            for (int index$iv = 0; index$iv < 64; index$iv++) {
                if ((this.lowerSet & (1 << index$iv)) != 0) {
                    int element = this.lowerBound + index$iv;
                    accumulator = operation.invoke(accumulator, Integer.valueOf(element));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int index$iv2 = 0; index$iv2 < 64; index$iv2++) {
                if ((this.upperSet & (1 << index$iv2)) != 0) {
                    int element2 = index$iv2 + 64 + this.lowerBound;
                    accumulator = operation.invoke(accumulator, Integer.valueOf(element2));
                }
            }
        }
        return (SnapshotIdSet) accumulator;
    }

    public final void fastForEach(Function1<? super Integer, Unit> block) {
        int[] belowBound = this.belowBound;
        if (belowBound != null) {
            for (int element : belowBound) {
                block.invoke(Integer.valueOf(element));
            }
        }
        if (this.lowerSet != 0) {
            for (int index = 0; index < 64; index++) {
                if ((this.lowerSet & (1 << index)) != 0) {
                    block.invoke(Integer.valueOf(this.lowerBound + index));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int index2 = 0; index2 < 64; index2++) {
                if ((this.upperSet & (1 << index2)) != 0) {
                    block.invoke(Integer.valueOf(index2 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final int lowest(int i) {
        int[] belowBound = this.belowBound;
        return belowBound != null ? belowBound[0] : this.lowerSet != 0 ? this.lowerBound + Long.numberOfTrailingZeros(this.lowerSet) : this.upperSet != 0 ? this.lowerBound + 64 + Long.numberOfTrailingZeros(this.upperSet) : i;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append(super.toString()).append(" [");
        SnapshotIdSet $this$map$iv = this;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            int it = ((Number) item$iv$iv).intValue();
            destination$iv$iv.add(String.valueOf(it));
        }
        return sbAppend.append(ListUtilsKt.fastJoinToString$default((List) destination$iv$iv, null, null, null, 0, null, null, 63, null)).append(']').toString();
    }

    /* compiled from: SnapshotIdSet.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }
}
