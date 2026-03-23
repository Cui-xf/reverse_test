package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: FocusInvalidationManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eJ%\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\t2\u0006\u0010\u0014\u001a\u0002H\u0015H\u0002¢\u0006\u0002\u0010\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "invalidateOwnerFocusState", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "focusEventNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusTargetsWithInvalidatedFocusEvents", "hasPendingInvalidation", "", "invalidateNodes", "scheduleInvalidation", "node", "T", "(Landroidx/collection/MutableScatterSet;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusInvalidationManager {
    public static final int $stable = 8;
    private final Function0<Unit> invalidateOwnerFocusState;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;
    private final MutableScatterSet<FocusTargetNode> focusTargetNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusEventModifierNode> focusEventNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusPropertiesModifierNode> focusPropertiesNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusTargetNode> focusTargetsWithInvalidatedFocusEvents = ScatterSetKt.mutableScatterSetOf();

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> function1, Function0<Unit> function0) {
        this.onRequestApplyChangesListener = function1;
        this.invalidateOwnerFocusState = function0;
    }

    public final void scheduleInvalidation(FocusTargetNode node) {
        scheduleInvalidation(this.focusTargetNodes, node);
    }

    public final void scheduleInvalidation(FocusEventModifierNode node) {
        scheduleInvalidation(this.focusEventNodes, node);
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode node) {
        scheduleInvalidation(this.focusPropertiesNodes, node);
    }

    public final boolean hasPendingInvalidation() {
        return this.focusTargetNodes.isNotEmpty() || this.focusPropertiesNodes.isNotEmpty() || this.focusEventNodes.isNotEmpty();
    }

    private final <T> void scheduleInvalidation(MutableScatterSet<T> mutableScatterSet, T t) {
        if (mutableScatterSet.add(t) && this.focusTargetNodes.get_size() + this.focusEventNodes.get_size() + this.focusPropertiesNodes.get_size() == 1) {
            this.onRequestApplyChangesListener.invoke(new AnonymousClass1(this));
        }
    }

    /* compiled from: FocusInvalidationManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.focus.FocusInvalidationManager$scheduleInvalidation$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object obj) {
            super(0, obj, FocusInvalidationManager.class, "invalidateNodes", "invalidateNodes()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((FocusInvalidationManager) this.receiver).invalidateNodes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v65, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r3v67 */
    /* JADX WARN: Type inference failed for: r3v70 */
    /* JADX WARN: Type inference failed for: r3v72 */
    /* JADX WARN: Type inference failed for: r4v33, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r52v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v25 */
    public final void invalidateNodes() {
        long j;
        char c;
        MutableScatterSet<FocusTargetNode> mutableScatterSet;
        int i;
        MutableScatterSet<FocusTargetNode> mutableScatterSet2;
        int i2;
        int i3;
        Object[] objArr;
        MutableScatterSet<FocusEventModifierNode> mutableScatterSet3;
        int i4;
        int i5;
        Object[] objArr2;
        MutableScatterSet<FocusEventModifierNode> mutableScatterSet4;
        int i6;
        FocusStateImpl focusState;
        FocusStateImpl focusState2;
        Modifier.Node node;
        MutableVector mutableVector;
        Object obj;
        FocusTargetNode focusTargetNode;
        DelegatingNode delegatingNode;
        int i7;
        MutableVector mutableVector2;
        int i8;
        DelegatingNode delegatingNode2;
        Modifier.Node node2;
        int i9;
        MutableVector mutableVector3;
        MutableScatterSet<FocusPropertiesModifierNode> mutableScatterSet5;
        int i10;
        Object[] objArr3;
        MutableScatterSet<FocusPropertiesModifierNode> mutableScatterSet6;
        int i11;
        Object[] objArr4;
        Modifier.Node node3;
        DelegatingNode delegatingNode3;
        Modifier.Node node4;
        int i12;
        MutableVector mutableVector4;
        MutableScatterSet<FocusPropertiesModifierNode> mutableScatterSet7;
        int i13;
        Object[] objArr5;
        int i14;
        Object[] objArr6;
        int i15;
        MutableVector mutableVector5;
        MutableScatterSet<FocusPropertiesModifierNode> mutableScatterSet8 = this.focusPropertiesNodes;
        int i16 = 0;
        Object[] objArr7 = mutableScatterSet8.elements;
        long[] jArr = mutableScatterSet8.metadata;
        int length = jArr.length - 2;
        int i17 = 0;
        char c2 = 7;
        if (0 <= length) {
            while (true) {
                long j2 = jArr[i17];
                j = 255;
                if ((((~j2) << c2) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i18 = 8 - ((~(i17 - length)) >>> 31);
                    int i19 = 0;
                    while (i19 < i18) {
                        if ((j2 & 255) < 128) {
                            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) objArr7[(i17 << 3) + i19];
                            if (focusPropertiesModifierNode.getNode().getIsAttached()) {
                                FocusPropertiesModifierNode focusPropertiesModifierNode2 = focusPropertiesModifierNode;
                                int iM5778constructorimpl = NodeKind.m5778constructorimpl(1024);
                                MutableVector mutableVector6 = null;
                                Modifier.Node node5 = focusPropertiesModifierNode2.getNode();
                                while (node5 != null) {
                                    if (node5 instanceof FocusTargetNode) {
                                        mutableScatterSet7 = mutableScatterSet8;
                                        this.focusTargetNodes.add((FocusTargetNode) node5);
                                        i13 = i16;
                                        objArr5 = objArr7;
                                    } else {
                                        mutableScatterSet7 = mutableScatterSet8;
                                        if (((node5.getKindSet() & iM5778constructorimpl) != 0) && (node5 instanceof DelegatingNode)) {
                                            int i20 = 0;
                                            Modifier.Node delegate = ((DelegatingNode) node5).getDelegate();
                                            while (delegate != null) {
                                                Modifier.Node node6 = delegate;
                                                if ((node6.getKindSet() & iM5778constructorimpl) != 0) {
                                                    i20++;
                                                    i14 = i16;
                                                    if (i20 == 1) {
                                                        node5 = node6;
                                                        objArr6 = objArr7;
                                                    } else {
                                                        if (mutableVector6 == null) {
                                                            i15 = i20;
                                                            objArr6 = objArr7;
                                                            mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            i15 = i20;
                                                            objArr6 = objArr7;
                                                            mutableVector5 = mutableVector6;
                                                        }
                                                        Modifier.Node node7 = node5;
                                                        if (node7 != null) {
                                                            if (mutableVector5 != null) {
                                                                Boolean.valueOf(mutableVector5.add(node7));
                                                            }
                                                            node5 = null;
                                                        }
                                                        if (mutableVector5 != null) {
                                                            Boolean.valueOf(mutableVector5.add(node6));
                                                        }
                                                        mutableVector6 = mutableVector5;
                                                        i20 = i15;
                                                    }
                                                } else {
                                                    i14 = i16;
                                                    objArr6 = objArr7;
                                                }
                                                delegate = delegate.getChild();
                                                i16 = i14;
                                                objArr7 = objArr6;
                                            }
                                            i13 = i16;
                                            objArr5 = objArr7;
                                            if (i20 == 1) {
                                                mutableScatterSet8 = mutableScatterSet7;
                                                i16 = i13;
                                                objArr7 = objArr5;
                                            }
                                        } else {
                                            i13 = i16;
                                            objArr5 = objArr7;
                                        }
                                    }
                                    node5 = DelegatableNodeKt.pop(mutableVector6);
                                    mutableScatterSet8 = mutableScatterSet7;
                                    i16 = i13;
                                    objArr7 = objArr5;
                                }
                                mutableScatterSet6 = mutableScatterSet8;
                                i11 = i16;
                                objArr4 = objArr7;
                                if (!focusPropertiesModifierNode2.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                                }
                                MutableVector mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child = focusPropertiesModifierNode2.getNode().getChild();
                                if (child == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector7, focusPropertiesModifierNode2.getNode());
                                } else {
                                    mutableVector7.add(child);
                                }
                                while (mutableVector7.isNotEmpty()) {
                                    Modifier.Node node8 = (Modifier.Node) mutableVector7.removeAt(mutableVector7.getSize() - 1);
                                    if ((node8.getAggregateChildKindSet() & iM5778constructorimpl) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector7, node8);
                                    } else {
                                        Modifier.Node child2 = node8;
                                        while (true) {
                                            if (child2 == null) {
                                                break;
                                            }
                                            if ((child2.getKindSet() & iM5778constructorimpl) != 0) {
                                                MutableVector mutableVector8 = null;
                                                MutableVector mutableVector9 = mutableVector7;
                                                Modifier.Node nodePop = child2;
                                                while (nodePop != null) {
                                                    Modifier.Node node9 = child;
                                                    if (nodePop instanceof FocusTargetNode) {
                                                        node3 = node8;
                                                        this.focusTargetNodes.add((FocusTargetNode) nodePop);
                                                    } else {
                                                        node3 = node8;
                                                        if (((nodePop.getKindSet() & iM5778constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                                            int i21 = 0;
                                                            DelegatingNode delegatingNode4 = (DelegatingNode) nodePop;
                                                            Modifier.Node delegate2 = delegatingNode4.getDelegate();
                                                            while (delegate2 != null) {
                                                                Modifier.Node node10 = delegate2;
                                                                if ((node10.getKindSet() & iM5778constructorimpl) != 0) {
                                                                    i21++;
                                                                    Modifier.Node node11 = nodePop;
                                                                    if (i21 == 1) {
                                                                        delegatingNode3 = delegatingNode4;
                                                                        node4 = node10;
                                                                    } else {
                                                                        if (mutableVector8 == null) {
                                                                            i12 = i21;
                                                                            delegatingNode3 = delegatingNode4;
                                                                            mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                                        } else {
                                                                            i12 = i21;
                                                                            delegatingNode3 = delegatingNode4;
                                                                            mutableVector4 = mutableVector8;
                                                                        }
                                                                        if (node11 != null) {
                                                                            if (mutableVector4 != null) {
                                                                                Boolean.valueOf(mutableVector4.add(node11));
                                                                            }
                                                                            node4 = null;
                                                                        } else {
                                                                            node4 = node11;
                                                                        }
                                                                        if (mutableVector4 != null) {
                                                                            Boolean.valueOf(mutableVector4.add(node10));
                                                                        }
                                                                        mutableVector8 = mutableVector4;
                                                                        i21 = i12;
                                                                    }
                                                                } else {
                                                                    delegatingNode3 = delegatingNode4;
                                                                    node4 = nodePop;
                                                                }
                                                                delegate2 = delegate2.getChild();
                                                                nodePop = node4;
                                                                delegatingNode4 = delegatingNode3;
                                                            }
                                                            Modifier.Node node12 = nodePop;
                                                            if (i21 == 1) {
                                                                child = node9;
                                                                node8 = node3;
                                                                nodePop = node12;
                                                            }
                                                        }
                                                    }
                                                    nodePop = DelegatableNodeKt.pop(mutableVector8);
                                                    child = node9;
                                                    node8 = node3;
                                                }
                                                mutableVector7 = mutableVector9;
                                            } else {
                                                child2 = child2.getChild();
                                            }
                                        }
                                    }
                                }
                            } else {
                                mutableScatterSet6 = mutableScatterSet8;
                                i11 = i16;
                                objArr4 = objArr7;
                            }
                        } else {
                            mutableScatterSet6 = mutableScatterSet8;
                            i11 = i16;
                            objArr4 = objArr7;
                        }
                        j2 >>= 8;
                        i19++;
                        mutableScatterSet8 = mutableScatterSet6;
                        i16 = i11;
                        objArr7 = objArr4;
                    }
                    mutableScatterSet5 = mutableScatterSet8;
                    i10 = i16;
                    objArr3 = objArr7;
                    c = 7;
                    if (i18 != 8) {
                        break;
                    }
                } else {
                    mutableScatterSet5 = mutableScatterSet8;
                    i10 = i16;
                    objArr3 = objArr7;
                    c = 7;
                }
                if (i17 == length) {
                    break;
                }
                i17++;
                mutableScatterSet8 = mutableScatterSet5;
                i16 = i10;
                objArr7 = objArr3;
                c2 = 7;
            }
        } else {
            j = 255;
            c = 7;
        }
        this.focusPropertiesNodes.clear();
        MutableScatterSet<FocusEventModifierNode> mutableScatterSet9 = this.focusEventNodes;
        int i22 = 0;
        Object[] objArr8 = mutableScatterSet9.elements;
        MutableScatterSet<FocusEventModifierNode> mutableScatterSet10 = mutableScatterSet9;
        int i23 = 0;
        long[] jArr2 = mutableScatterSet10.metadata;
        int length2 = jArr2.length - 2;
        int i24 = 0;
        if (0 <= length2) {
            while (true) {
                long j3 = jArr2[i24];
                MutableScatterSet<FocusEventModifierNode> mutableScatterSet11 = mutableScatterSet9;
                int i25 = i22;
                if ((((~j3) << c) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i26 = 8 - ((~(i24 - length2)) >>> 31);
                    int i27 = 0;
                    while (i27 < i26) {
                        if ((j3 & j) < 128) {
                            i5 = i27;
                            FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) objArr8[(i24 << 3) + i27];
                            if (focusEventModifierNode.getNode().getIsAttached()) {
                                objArr2 = objArr8;
                                boolean z = false;
                                FocusTargetNode focusTargetNode2 = null;
                                FocusEventModifierNode focusEventModifierNode2 = focusEventModifierNode;
                                int iM5778constructorimpl2 = NodeKind.m5778constructorimpl(1024);
                                MutableVector mutableVector10 = null;
                                Object obj2 = 1;
                                Modifier.Node node13 = focusEventModifierNode2.getNode();
                                while (node13 != null) {
                                    MutableScatterSet<FocusEventModifierNode> mutableScatterSet12 = mutableScatterSet10;
                                    if (node13 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode3 = node13;
                                        if (focusTargetNode2 != null) {
                                            z = true;
                                        }
                                        focusTargetNode2 = focusTargetNode3;
                                        i8 = i23;
                                        if (this.focusTargetNodes.contains(focusTargetNode3)) {
                                            obj2 = null;
                                            this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode3);
                                        }
                                    } else {
                                        i8 = i23;
                                        if (((node13.getKindSet() & iM5778constructorimpl2) != 0) && (node13 instanceof DelegatingNode)) {
                                            int i28 = 0;
                                            DelegatingNode delegatingNode5 = node13;
                                            Modifier.Node delegate3 = delegatingNode5.getDelegate();
                                            while (delegate3 != null) {
                                                Modifier.Node node14 = delegate3;
                                                if ((node14.getKindSet() & iM5778constructorimpl2) != 0) {
                                                    i28++;
                                                    Modifier.Node node15 = node13;
                                                    if (i28 == 1) {
                                                        delegatingNode2 = delegatingNode5;
                                                        node2 = node14;
                                                    } else {
                                                        if (mutableVector10 == null) {
                                                            i9 = i28;
                                                            delegatingNode2 = delegatingNode5;
                                                            mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            i9 = i28;
                                                            delegatingNode2 = delegatingNode5;
                                                            mutableVector3 = mutableVector10;
                                                        }
                                                        if (node15 != null) {
                                                            if (mutableVector3 != null) {
                                                                Boolean.valueOf(mutableVector3.add(node15));
                                                            }
                                                            node2 = null;
                                                        } else {
                                                            node2 = node15;
                                                        }
                                                        if (mutableVector3 != null) {
                                                            Boolean.valueOf(mutableVector3.add(node14));
                                                        }
                                                        mutableVector10 = mutableVector3;
                                                        i28 = i9;
                                                    }
                                                } else {
                                                    delegatingNode2 = delegatingNode5;
                                                    node2 = node13;
                                                }
                                                delegate3 = delegate3.getChild();
                                                node13 = node2;
                                                delegatingNode5 = delegatingNode2;
                                            }
                                            Modifier.Node node16 = node13;
                                            if (i28 == 1) {
                                                mutableScatterSet10 = mutableScatterSet12;
                                                i23 = i8;
                                                node13 = node16;
                                            }
                                        }
                                    }
                                    node13 = DelegatableNodeKt.pop(mutableVector10);
                                    mutableScatterSet10 = mutableScatterSet12;
                                    i23 = i8;
                                }
                                mutableScatterSet4 = mutableScatterSet10;
                                i6 = i23;
                                if (!focusEventModifierNode2.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                                }
                                MutableVector mutableVector11 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child3 = focusEventModifierNode2.getNode().getChild();
                                if (child3 == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector11, focusEventModifierNode2.getNode());
                                } else {
                                    mutableVector11.add(child3);
                                }
                                while (mutableVector11.isNotEmpty()) {
                                    ?? r5 = (Modifier.Node) mutableVector11.removeAt(mutableVector11.getSize() - 1);
                                    if ((r5.getAggregateChildKindSet() & iM5778constructorimpl2) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector11, r5);
                                        node = child3;
                                        mutableVector = mutableVector11;
                                    } else {
                                        for (FocusTargetNode child4 = r5; child4 != null; child4 = child4.getChild()) {
                                            if ((child4.getKindSet() & iM5778constructorimpl2) != 0) {
                                                MutableVector mutableVector12 = null;
                                                Modifier.Node node17 = child3;
                                                FocusTargetNode focusTargetNodePop = child4;
                                                while (focusTargetNodePop != null) {
                                                    MutableVector mutableVector13 = mutableVector11;
                                                    if (focusTargetNodePop instanceof FocusTargetNode) {
                                                        FocusTargetNode focusTargetNode4 = focusTargetNodePop;
                                                        if (focusTargetNode2 != null) {
                                                            z = true;
                                                        }
                                                        focusTargetNode2 = focusTargetNode4;
                                                        obj = r5;
                                                        if (this.focusTargetNodes.contains(focusTargetNode4)) {
                                                            obj2 = null;
                                                            this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode4);
                                                        }
                                                    } else {
                                                        obj = r5;
                                                        if (((focusTargetNodePop.getKindSet() & iM5778constructorimpl2) != 0) && (focusTargetNodePop instanceof DelegatingNode)) {
                                                            int i29 = 0;
                                                            DelegatingNode delegatingNode6 = (DelegatingNode) focusTargetNodePop;
                                                            for (FocusTargetNode delegate4 = delegatingNode6.getDelegate(); delegate4 != null; delegate4 = delegate4.getChild()) {
                                                                FocusTargetNode focusTargetNode5 = delegate4;
                                                                if ((focusTargetNode5.getKindSet() & iM5778constructorimpl2) != 0) {
                                                                    i29++;
                                                                    focusTargetNode = focusTargetNodePop;
                                                                    if (i29 == 1) {
                                                                        focusTargetNode = focusTargetNode5;
                                                                        delegatingNode = delegatingNode6;
                                                                    } else {
                                                                        if (mutableVector12 == null) {
                                                                            i7 = i29;
                                                                            delegatingNode = delegatingNode6;
                                                                            mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                                        } else {
                                                                            i7 = i29;
                                                                            delegatingNode = delegatingNode6;
                                                                            mutableVector2 = mutableVector12;
                                                                        }
                                                                        if (focusTargetNode != null) {
                                                                            if (mutableVector2 != null) {
                                                                                Boolean.valueOf(mutableVector2.add(focusTargetNode));
                                                                            }
                                                                            focusTargetNode = null;
                                                                        }
                                                                        if (mutableVector2 != null) {
                                                                            Boolean.valueOf(mutableVector2.add(focusTargetNode5));
                                                                        }
                                                                        mutableVector12 = mutableVector2;
                                                                        i29 = i7;
                                                                    }
                                                                } else {
                                                                    focusTargetNode = focusTargetNodePop;
                                                                    delegatingNode = delegatingNode6;
                                                                }
                                                                focusTargetNodePop = focusTargetNode;
                                                                delegatingNode6 = delegatingNode;
                                                            }
                                                            FocusTargetNode focusTargetNode6 = focusTargetNodePop;
                                                            if (i29 == 1) {
                                                                mutableVector11 = mutableVector13;
                                                                r5 = obj;
                                                                focusTargetNodePop = focusTargetNode6;
                                                            }
                                                        }
                                                    }
                                                    focusTargetNodePop = DelegatableNodeKt.pop(mutableVector12);
                                                    mutableVector11 = mutableVector13;
                                                    r5 = obj;
                                                }
                                                child3 = node17;
                                            } else {
                                                child3 = child3;
                                            }
                                        }
                                        node = child3;
                                        mutableVector = mutableVector11;
                                    }
                                    child3 = node;
                                    mutableVector11 = mutableVector;
                                }
                                if (obj2 != null) {
                                    if (z) {
                                        focusState2 = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                    } else {
                                        if (focusTargetNode2 == null || (focusState = focusTargetNode2.getFocusState()) == null) {
                                            focusState = FocusStateImpl.Inactive;
                                        }
                                        focusState2 = focusState;
                                    }
                                    focusEventModifierNode.onFocusEvent(focusState2);
                                }
                            } else {
                                objArr2 = objArr8;
                                focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                                mutableScatterSet4 = mutableScatterSet10;
                                i6 = i23;
                            }
                        } else {
                            i5 = i27;
                            objArr2 = objArr8;
                            mutableScatterSet4 = mutableScatterSet10;
                            i6 = i23;
                        }
                        j3 >>= 8;
                        i27 = i5 + 1;
                        objArr8 = objArr2;
                        mutableScatterSet10 = mutableScatterSet4;
                        i23 = i6;
                    }
                    objArr = objArr8;
                    mutableScatterSet3 = mutableScatterSet10;
                    i4 = i23;
                    if (i26 != 8) {
                        break;
                    }
                } else {
                    objArr = objArr8;
                    mutableScatterSet3 = mutableScatterSet10;
                    i4 = i23;
                }
                if (i24 == length2) {
                    break;
                }
                i24++;
                mutableScatterSet9 = mutableScatterSet11;
                i22 = i25;
                objArr8 = objArr;
                mutableScatterSet10 = mutableScatterSet3;
                i23 = i4;
            }
        }
        this.focusEventNodes.clear();
        MutableScatterSet<FocusTargetNode> mutableScatterSet13 = this.focusTargetNodes;
        int i30 = 0;
        Object[] objArr9 = mutableScatterSet13.elements;
        long[] jArr3 = mutableScatterSet13.metadata;
        int length3 = jArr3.length - 2;
        int i31 = 0;
        if (0 <= length3) {
            while (true) {
                long j4 = jArr3[i31];
                Object[] objArr10 = objArr9;
                if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i32 = 8 - ((~(i31 - length3)) >>> 31);
                    int i33 = 0;
                    while (i33 < i32) {
                        if ((j4 & j) < 128) {
                            mutableScatterSet2 = mutableScatterSet13;
                            FocusTargetNode focusTargetNode7 = (FocusTargetNode) objArr10[(i31 << 3) + i33];
                            if (focusTargetNode7.getIsAttached()) {
                                i2 = i30;
                                FocusStateImpl focusState3 = focusTargetNode7.getFocusState();
                                focusTargetNode7.invalidateFocus$ui_release();
                                i3 = i33;
                                if (focusState3 != focusTargetNode7.getFocusState() || this.focusTargetsWithInvalidatedFocusEvents.contains(focusTargetNode7)) {
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode7);
                                }
                            } else {
                                i2 = i30;
                                i3 = i33;
                            }
                        } else {
                            mutableScatterSet2 = mutableScatterSet13;
                            i2 = i30;
                            i3 = i33;
                        }
                        j4 >>= 8;
                        i33 = i3 + 1;
                        mutableScatterSet13 = mutableScatterSet2;
                        i30 = i2;
                    }
                    mutableScatterSet = mutableScatterSet13;
                    i = i30;
                    if (i32 != 8) {
                        break;
                    }
                } else {
                    mutableScatterSet = mutableScatterSet13;
                    i = i30;
                }
                if (i31 == length3) {
                    break;
                }
                i31++;
                objArr9 = objArr10;
                mutableScatterSet13 = mutableScatterSet;
                i30 = i;
            }
        }
        this.focusTargetNodes.clear();
        this.focusTargetsWithInvalidatedFocusEvents.clear();
        this.invalidateOwnerFocusState.invoke();
        if (!this.focusPropertiesNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusProperties nodes");
        }
        if (!this.focusEventNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusEvent nodes");
        }
        if (this.focusTargetNodes.isEmpty()) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusTarget nodes");
    }
}
